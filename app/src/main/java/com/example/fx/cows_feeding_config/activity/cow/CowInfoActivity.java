package com.example.fx.cows_feeding_config.activity.cow;

import android.app.Activity;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.view.KeyEvent;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.example.fx.cows_feeding_config.R;
import com.example.fx.cows_feeding_config.entity.Cow;

import org.litepal.crud.DataSupport;

public class CowInfoActivity extends AppCompatActivity {

    private TextView etVariety;
    private TextView etWeight;
    private TextView etMilkDays;
    private TextView etMilkProduction;
    private TextView etMilkFat;
    private Button btnChangeCow;
    private Button btnDeleteCow;

    private Cow cow;
    private Cow target;
    private int position;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cow_info);
        initView();
        cow = getIntent().getParcelableExtra("cow");
        position = getIntent().getIntExtra("position", -1);
        initData(cow);
        initEvent();
    }

    @Override
    protected void onResume() {
        super.onResume();
        initData(target);
    }

    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        if (keyCode == KeyEvent.KEYCODE_BACK && event.getRepeatCount() == 0) {
            Intent intent = getIntent();
            Bundle bundle = intent.getExtras();
            bundle.putParcelable("newCow", target);
            bundle.putInt("click", position);
            intent.putExtras(bundle);
            setResult(RESULT_OK, intent);
            finish();
            return true;
        }
        return false;
    }

    private void initView() {
        this.etMilkFat = (TextView) findViewById(R.id.tv_milk_fat);
        this.etMilkProduction = (TextView) findViewById(R.id.tv_milk_production);
        this.etMilkDays = (TextView) findViewById(R.id.tv_milk_days);
        this.etWeight = (TextView) findViewById(R.id.tv_weight);
        this.etVariety = (TextView) findViewById(R.id.tv_variety);
        this.btnChangeCow = (Button) findViewById(R.id.btn_change_cow);
        this.btnDeleteCow = (Button) findViewById(R.id.btn_delete_cow);
    }

    private void initData(Cow cow) {
        if (cow != null) {
            etVariety.setText(String.valueOf(cow.getVariety()));
            etWeight.setText(String.valueOf(cow.getWeight()));
            etMilkDays.setText(String.valueOf(cow.getMilkDays()));
            etMilkProduction.setText(String.valueOf(cow.getMilkProduction()));
            etMilkFat.setText(String.valueOf(cow.getMilkFat()));
        }
    }

    private void initEvent() {
        btnChangeCow.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(CowInfoActivity.this, CowAddActivity.class);
                intent.putExtra("cow", cow);
                Bundle bundle = new Bundle();
                intent.putExtras(bundle);
                startActivityForResult(intent, 4);
            }
        });
        btnDeleteCow.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                AlertDialog.Builder builder = new AlertDialog.Builder(CowInfoActivity.this);
                builder.setMessage("删除后将无法恢复，确认删除这条记录吗?");
                builder.setPositiveButton("确认", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        DataSupport.delete(Cow.class, cow.getId());
                        Intent intent=getIntent();
                        intent.putExtra("del",position);
                        Bundle bundle = new Bundle();
                        intent.putExtras(bundle);
                        setResult(RESULT_CANCELED, intent);
                        finish();
                    }
                });
                builder.setNegativeButton("取消", null);
                builder.show();
            }
        });
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == 4 && resultCode == Activity.RESULT_OK) {
            Bundle bundle = data.getExtras();
            target = bundle.getParcelable("target");
        }
    }
}
