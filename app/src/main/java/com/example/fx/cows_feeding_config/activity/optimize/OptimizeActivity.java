package com.example.fx.cows_feeding_config.activity.optimize;

import android.app.Activity;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.os.Parcelable;
import android.support.annotation.NonNull;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.ListView;
import android.widget.Toast;

import com.example.fx.cows_feeding_config.R;
import com.example.fx.cows_feeding_config.adapter.CowListAdapter;
import com.example.fx.cows_feeding_config.adapter.FodderInfoAdapter;
import com.example.fx.cows_feeding_config.entity.Cow;
import com.example.fx.cows_feeding_config.entity.Fodder;
import com.example.fx.cows_feeding_config.util.ObjectToJsonUtil;

import org.json.JSONException;
import org.json.JSONObject;
import org.litepal.crud.DataSupport;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.MediaType;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;

/**
 * Created by fx on 2017/9/13.
 */

public class OptimizeActivity extends AppCompatActivity implements View.OnClickListener {

    public static final MediaType JSON = MediaType.parse("application/json; charset=utf-8");
    private static final String LP_URL = "http://127.0.0.1:80";

    private Button btnSelectCow;
    private Button btnSelectFodder;
    private ListView lvSelectFodder;
    private Button btn1;
    private Button btn2;

    private List<Cow> cowList;
    private List<Fodder> fodderInfoList = new ArrayList<>();

    private FodderInfoAdapter adapter;

    private Cow cow;

    //粗饲料
    private int coarse;

    //精饲料
    private int concentrate;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_optimize);
        initView();
        initData();
        initEvent();
    }

    private void initView() {
        this.btnSelectCow = (Button) findViewById(R.id.btn_select_cow);
        this.btnSelectFodder = (Button) findViewById(R.id.btn_select_fodder);
        this.lvSelectFodder = (ListView) findViewById(R.id.lv_select_fodder);
        this.btn1 = (Button) findViewById(R.id.btn_1);
        this.btn2 = (Button) findViewById(R.id.btn_2);
    }

    private void initData() {
        cowList = DataSupport.findAll(Cow.class);
        adapter = new FodderInfoAdapter(OptimizeActivity.this, R.layout.info_item, fodderInfoList);
        lvSelectFodder.setAdapter(adapter);
    }

    private void initEvent() {
        btnSelectCow.setOnClickListener(this);
        btnSelectFodder.setOnClickListener(this);
        btn1.setOnClickListener(this);
        btn2.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.btn_select_cow:
                AlertDialog.Builder cowBuilder = new AlertDialog.Builder(this);
                cowBuilder.setSingleChoiceItems(new CowListAdapter(this, R.layout.item, cowList), 0, new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        ListView listView = ((AlertDialog) dialogInterface).getListView();
                        cow = (Cow) listView.getAdapter().getItem(i);
                        dialogInterface.dismiss();
                        btnSelectCow.setText(cow.getVariety() + "重" + cow.getWeight() + "产乳" + cow.getMilkProduction());
                    }
                }).create().show();
                break;
            case R.id.btn_select_fodder:
                Intent intent = new Intent(OptimizeActivity.this, FodderSelectActivity.class);
                Bundle bundle = new Bundle();
                intent.putExtras(bundle);
                intent.putParcelableArrayListExtra("infoList", (ArrayList<? extends Parcelable>) fodderInfoList);
                startActivityForResult(intent, 8);
                break;
            case R.id.btn_1:
                if (cow == null) {
                    Toast.makeText(this, "请选择奶牛营养指标", Toast.LENGTH_SHORT).show();
                    return;
                }
                if (fodderInfoList == null || fodderInfoList.size() == 0) {
                    Toast.makeText(this, "请选择饲料", Toast.LENGTH_SHORT).show();
                    return;
                }
                adapter.setContent();
                OkHttpClient client = new OkHttpClient();
                JSONObject requestObject = null;
                try {
                    requestObject = ObjectToJsonUtil.objectToJson(fodderInfoList, cow, coarse, concentrate);
                } catch (JSONException e) {
                    Toast.makeText(this, "未知错误", Toast.LENGTH_SHORT).show();
                    e.printStackTrace();
                }
                if (requestObject != null) {
                    RequestBody requestBody = RequestBody.create(JSON, requestObject.toString());
                    Request request = new Request.Builder().url(LP_URL).post(requestBody).build();
                    client.newCall(request).enqueue(new Callback() {
                        @Override
                        public void onFailure(@NonNull Call call, @NonNull IOException e) {
                            OptimizeActivity.this.runOnUiThread(new Runnable() {
                                @Override
                                public void run() {
                                    Toast.makeText(OptimizeActivity.this, "网络异常", Toast.LENGTH_SHORT).show();
                                }
                            });
                        }

                        @Override
                        public void onResponse(@NonNull Call call, @NonNull Response response) throws IOException {
                            String responseData = response.body().string();
//                          TODO 回调
                        }
                    });
                }
                break;
            case R.id.btn_2:
                // TODO
                adapter.setContent();
                break;
        }
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == 8 && resultCode == Activity.RESULT_OK) {
            Bundle bundle = data.getExtras();
            ArrayList<Fodder> selectList = bundle.getParcelableArrayList("fodderInfoList");
            ArrayList<Fodder> fodderRemoveList = bundle.getParcelableArrayList("fodderRemoveList");
            if (selectList != null) {
                for (Fodder fodder : selectList) {
                    fodderInfoList.add(fodder);
                }
            }
            List<Fodder> temp = new ArrayList<>();
            if (fodderRemoveList != null) {
                for (Fodder fodder : fodderRemoveList) {
                    for (Fodder fodderInfo : fodderInfoList) {
                        if (fodder.getId() == fodderInfo.getId()) {
                            temp.add(fodderInfo);
                        }
                    }
                }
            }
            for (Fodder t : temp) {
                fodderInfoList.remove(t);
            }
            int coarseNum = 0;
            int concentrateNum = 0;
            for (Fodder fodder : fodderInfoList) {
                if (fodder.getType() == 1) {
                    coarseNum++;
                } else if (fodder.getType() == 2) {
                    concentrateNum++;
                }
            }
            coarse = coarseNum;
            concentrate = concentrateNum;
            btnSelectFodder.setText("选择粗饲料" + coarseNum + "种,精饲料" + concentrateNum + "种，单位kg");
            adapter.notifyDataSetChanged();
        }
    }
}

