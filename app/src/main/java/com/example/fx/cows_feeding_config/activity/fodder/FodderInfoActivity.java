package com.example.fx.cows_feeding_config.activity.fodder;

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
import com.example.fx.cows_feeding_config.entity.Fodder;

import org.litepal.crud.DataSupport;

public class FodderInfoActivity extends AppCompatActivity {


    private TextView tvName;
    private TextView tvType;
    private TextView tvDryMatter;
    private TextView tvCrudeProtein;
    private TextView tvEnergy;
    private TextView tvCalcium;
    private TextView tvPhosphorus;
    private TextView tvSodium;
    private TextView tvChlorine;
    private TextView tvPotassium;
    private TextView tvMagnesium;
    private TextView tvSulphur;
    private TextView tvCrudeFat;
    private TextView tvPrice;
    private Button btnChangeFodder;
    private Button btnDeleteFodder;

    private Fodder fodder;
    private Fodder target;
    private int position;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fodder_info);
        initView();
        fodder = getIntent().getParcelableExtra("fodder");
        position = getIntent().getIntExtra("position", -1);
        initData(fodder);
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
            bundle.putParcelable("newFodder", target);
            bundle.putInt("click", position);
            intent.putExtras(bundle);
            setResult(RESULT_OK, intent);
            finish();
            return true;
        }
        return false;
    }


    private void initView() {
        this.tvPrice = (TextView) findViewById(R.id.tv_price);
        this.tvCrudeProtein = (TextView) findViewById(R.id.tv_crude_protein);
        this.tvDryMatter = (TextView) findViewById(R.id.tv_dry_matter);
        this.tvEnergy = (TextView) findViewById(R.id.tv_energy);
        this.tvCalcium = (TextView) findViewById(R.id.tv_calcium);
        this.tvPhosphorus = (TextView) findViewById(R.id.tv_phosphorus);
        this.tvSodium = (TextView) findViewById(R.id.tv_sodium);
        this.tvChlorine = (TextView) findViewById(R.id.tv_chlorine);
        this.tvPotassium = (TextView) findViewById(R.id.tv_potassium);
        this.tvMagnesium = (TextView) findViewById(R.id.tv_magnesium);
        this.tvSulphur = (TextView) findViewById(R.id.tv_sulphur);
        this.tvCrudeFat = (TextView) findViewById(R.id.tv_crude_fat);
        this.tvType = (TextView) findViewById(R.id.tv_type);
        this.tvName = (TextView) findViewById(R.id.tv_name);
        this.btnChangeFodder = (Button) findViewById(R.id.btn_change_fodder);
        this.btnDeleteFodder = (Button) findViewById(R.id.btn_delete_fodder);
    }

    private void initData(Fodder fodder) {
        if (fodder != null) {
            tvName.setText(fodder.getName());
            tvType.setText(fodder.getType() == 1 ? "精饲料" : fodder.getType() == 2 ? "粗饲料" : "添加剂");
            tvDryMatter.setText(String.valueOf(fodder.getDryMatter()));
            tvCrudeProtein.setText(String.valueOf(fodder.getCrudeProtein()));
            tvEnergy.setText(String.valueOf(fodder.getEnergy()));
            tvCalcium.setText(String.valueOf(fodder.getCalcium()));
            tvPhosphorus.setText(String.valueOf(fodder.getPhosphorus()));
            tvSodium.setText(String.valueOf(fodder.getSodium()));
            tvChlorine.setText(String.valueOf(fodder.getChlorine()));
            tvPotassium.setText(String.valueOf(fodder.getPotassium()));
            tvMagnesium.setText(String.valueOf(fodder.getMagnesium()));
            tvSulphur.setText(String.valueOf(fodder.getSulphur()));
            tvCrudeFat.setText(String.valueOf(fodder.getCrudeFat()));
            tvPrice.setText(fodder.getPrice() != 0 ? String.valueOf(fodder.getPrice()) : "暂无价格");
        }
    }

    private void initEvent() {
        btnChangeFodder.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(FodderInfoActivity.this, FodderAddActivity.class);
                intent.putExtra("fodder", fodder);
                Bundle bundle = new Bundle();
                intent.putExtras(bundle);
                startActivityForResult(intent, 1);
            }
        });
        btnDeleteFodder.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                AlertDialog.Builder builder = new AlertDialog.Builder(FodderInfoActivity.this);
                builder.setMessage("删除后将无法恢复，确认删除这条记录吗?");
                builder.setPositiveButton("确认", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        DataSupport.delete(Fodder.class, fodder.getId());
                        Intent intent = getIntent();
                        intent.putExtra("del", position);
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
        if (requestCode == 1 && resultCode == Activity.RESULT_OK) {
            Bundle bundle = data.getExtras();
            target = bundle.getParcelable("target");
        }
    }
}
