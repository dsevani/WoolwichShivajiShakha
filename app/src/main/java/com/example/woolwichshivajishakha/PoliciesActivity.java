package com.example.woolwichshivajishakha;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import androidx.appcompat.app.AppCompatActivity;
import java.util.ArrayList;

public class PoliciesActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_policies);

        ListView listView= findViewById(R.id.listview);

        final ArrayList<String> arrayList=new ArrayList<>();

        arrayList.add("CODE OF CONDUCT");
        arrayList.add("EQUAL OPPORTUNITIES POLICY");
        arrayList.add("STAFF DEVELOPMENT / CODE OF PRACTICE POLICY");
        arrayList.add("HEALTH AND SAFETY POLICY");
        arrayList.add("SAFE TO TRUST");



        ArrayAdapter arrayAdapter=new ArrayAdapter(this,android.R.layout.simple_list_item_1,arrayList);

        listView.setAdapter(arrayAdapter);


}
}