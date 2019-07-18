package steedserv.com.eco_agri;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

import steedserv.com.eco_agri.server.callbacks.GetCattlesCallback;
import steedserv.com.eco_agri.server.dao.CattlesDAO;
import steedserv.com.eco_agri.server.pojo.Cattles;
import steedserv.com.eco_agri.server.pojo.CattlesListResponse;

public class animalDetails extends AppCompatActivity {

    List<Cattles> mcattlelsit=new ArrayList<>(  );
    AnimalAdapter animalAdapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_animal_details);

        RecyclerView recyclerView=(RecyclerView)findViewById(R.id.animals_list);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        animalAdapter =new AnimalAdapter(getApplicationContext(),mcattlelsit);
        recyclerView.setAdapter(animalAdapter);

    }


    public void goToAddAnimalDetails(View view) {
        Intent intent=new Intent(animalDetails.this,add_animals_details.class);
        startActivity(intent);
    }


    public void goBackToHomepage(View view)
    {
        finish();
    }


    @Override
    protected void onResume() {
        super.onResume();

        CattlesDAO.getCattlesList( new GetCattlesCallback() {
            @Override
            public void onSuccessResponse(CattlesListResponse response) {
                if(response.getData().size()>0){
                    mcattlelsit.clear();
                    mcattlelsit.addAll(response.getData());
                    animalAdapter.notifyDataSetChanged();
                }else{
                    mcattlelsit.clear();
                }
            }

            @Override
            public void onFailure(String s) {
                Toast.makeText(animalDetails.this, "plz try again Later", Toast.LENGTH_SHORT).show();
            }
        } );
    }
}
