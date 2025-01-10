package com.example.myapp;

import android.os.Bundle;
import android.view.ContextMenu;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ListView;
import android.widget.PopupMenu;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class ContextDemoActivity extends AppCompatActivity {
    private Toolbar toolbar1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_context_demo);

        TextView tvName=findViewById(R.id.tvName);
        EditText etSearch=findViewById(R.id.etSearch);
        Button img=findViewById(R.id.btnNavigation);
        ListView listView=findViewById(R.id.lvCategories);
        Spinner spinner=findViewById(R.id.spinner);
        String[] catg={"Food","Entertainment","Education","Rent and bills"};
        ArrayAdapter<String> arrayAdapter=new ArrayAdapter<>(this, android.R.layout.simple_list_item_1,catg);
        listView.setAdapter(arrayAdapter);

        String[] spinnerList= getResources().getStringArray(R.array.language);
        ArrayAdapter<String> spinnerAdapter=new ArrayAdapter<>(this, android.R.layout.simple_spinner_item,spinnerList);
        spinnerAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner.setAdapter(spinnerAdapter);

        //registerForContextMenu(tvName);
        registerForContextMenu(etSearch);

        toolbar1=findViewById(R.id.toolbar1);
        setSupportActionBar(toolbar1);
        getSupportActionBar().setDisplayShowTitleEnabled(false);

        //Listview
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                String item=catg[position];
                Toast.makeText(getApplicationContext(),item,Toast.LENGTH_LONG).show();
            }
        });

        //spinner
        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                String sel=spinnerList[position];
                Toast.makeText(getApplicationContext(),sel,Toast.LENGTH_LONG).show();
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });

        img.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                PopupMenu popupMenu=new PopupMenu(ContextDemoActivity.this,img);
                getMenuInflater().inflate(R.menu.popup_menu,popupMenu.getMenu());

        popupMenu.setOnMenuItemClickListener(new PopupMenu.OnMenuItemClickListener() {
           @Override
           public boolean onMenuItemClick(MenuItem item) {
               if(item.getItemId()==R.id.pop1)
                {
                    Toast.makeText(getApplicationContext(),"Expenses clicked",Toast.LENGTH_SHORT).show();
                }
                else if(item.getItemId()==R.id.pop2)
                {
                    Toast.makeText(getApplicationContext(),"Categories clicked",Toast.LENGTH_SHORT).show();
                }
                return true;
           }
        });
        popupMenu.show();
            }
        });



    }

    @Override
    public void onCreateContextMenu(ContextMenu menu, View v, ContextMenu.ContextMenuInfo menuInfo) {
        if(v.getId()==R.id.etSearch)
        {
            getMenuInflater().inflate(R.menu.context_menu2,menu);
            super.onCreateContextMenu(menu, v, menuInfo);
        }

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.option_menu,menu);
        return super.onCreateOptionsMenu(menu);
    }

//    public void popupOpen(View view)
//    {
//        PopupMenu popupMenu=new PopupMenu(this,img);
//        getMenuInflater().inflate(R.menu.popup_menu,popupMenu.getMenu());
//
//        popupMenu.setOnMenuItemClickListener(new PopupMenu.OnMenuItemClickListener() {
//            @Override
//            public boolean onMenuItemClick(MenuItem item) {
////                if(item.getItemId()==R.id.pop1)
////                {
////                    Toast.makeText(getApplicationContext(),"Expenses clicked",Toast.LENGTH_SHORT).show();
////                }
////                else if(item.getItemId()==R.id.pop2)
////                {
////                    Toast.makeText(getApplicationContext(),"Categories clicked",Toast.LENGTH_SHORT).show();
////                }
//                return true;
//           }
//        });
//        popupMenu.show();


}