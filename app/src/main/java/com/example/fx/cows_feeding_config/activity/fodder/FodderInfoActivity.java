package com.example.fx.cows_feeding_config.activity.fodder;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.example.fx.cows_feeding_config.R;
import com.example.fx.cows_feeding_config.entity.Fodder;

public class FodderInfoActivity extends AppCompatActivity {


    private TextView tvName;
    private TextView tvType;
    private TextView tvDryMatter;
    private TextView tvCalcium;
    private TextView tvPhosphorus;
    private TextView tvEnergy;
    private TextView tvCrudeProtein;
    private TextView tvPrice;
    private Button btnChangeFodder;
    private Button btnDeleteFodder;

    private Fodder fodder;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fodder_info);
        initView();
        initData();
        initEvent();
    }

    private void initView() {
        this.tvPrice = (TextView) findViewById(R.id.tv_price);
        this.tvCrudeProtein = (TextView) findViewById(R.id.tv_crude_protein);
        this.tvEnergy = (TextView) findViewById(R.id.tv_energy);
        this.tvPhosphorus = (TextView) findViewById(R.id.tv_phosphorus);
        this.tvCalcium = (TextView) findViewById(R.id.tv_calcium);
        this.tvDryMatter = (TextView) findViewById(R.id.tv_dry_matter);
        this.tvType = (TextView) findViewById(R.id.tv_type);
        this.tvName = (TextView) findViewById(R.id.tv_name);
        this.btnChangeFodder = (Button) findViewById(R.id.btn_change_fodder);
        this.btnDeleteFodder = (Button) findViewById(R.id.btn_delete_fodder);
    }

    private void initData() {
        fodder = getIntent().getParcelableExtra("fodder");
        if (fodder != null) {
            tvName.setText(fodder.getName());
            tvType.setText(fodder.getType() == 1 ? "粗饲料" : "精饲料");
            tvDryMatter.setText(String.valueOf(fodder.getDryMatter()));
            tvCalcium.setText(String.valueOf(fodder.getCalcium()));
            tvPhosphorus.setText(String.valueOf(fodder.getPhosphorus()));
            tvEnergy.setText(String.valueOf(fodder.getEnergy()));
            tvCrudeProtein.setText(String.valueOf(fodder.getCrudeProtein()));
            tvPrice.setText(fodder.getPrice() != 0 ? String.valueOf(fodder.getPrice()) : "暂无价格");
        }
    }

    private void initEvent() {
        btnChangeFodder.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(FodderInfoActivity.this, FodderAddActivity.class);
                intent.putExtra("fodder", fodder);
                startActivity(intent);
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
                        // TODO 删除逻辑
                    }
                });
                builder.setNegativeButton("取消", null);
                builder.show();
            }
        });
    }
}
