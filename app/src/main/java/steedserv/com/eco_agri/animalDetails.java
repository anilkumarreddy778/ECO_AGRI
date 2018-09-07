package steedserv.com.eco_agri;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;

public class animalDetails extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_animal_details);

        RecyclerView recyclerView=(RecyclerView)findViewById(R.id.animals_list);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        AnimalAdapter animalAdapter=new AnimalAdapter(getApplicationContext());
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
}
