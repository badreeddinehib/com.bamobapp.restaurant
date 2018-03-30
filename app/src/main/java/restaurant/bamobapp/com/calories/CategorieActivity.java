package restaurant.bamobapp.com.calories;

import android.content.Context;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

public class CategorieActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_categorie);
        this.configureToolBare();
       /* GridView list = (GridView)findViewById(R.id.grid_view);
        list.setAdapter(new ListResources(this));*/
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu)
    {
        getMenuInflater().inflate(R.menu.menu_activity_main,menu);
        return true ;
    }

    private void configureToolBare()
    {
        Toolbar toolbar = (Toolbar)findViewById(R.id.activity_main_toolbar);
        setSupportActionBar(toolbar);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        //3 - Handle actions on menu items
        switch (item.getItemId()) {
            case R.id.menu_activity_main_params:
                Toast.makeText(this, "Il n'y a rien à paramétrer ici, passez votre chemin...", Toast.LENGTH_LONG).show();
                return true;
            case R.id.menu_activity_main_search:
                Toast.makeText(this, "Recherche indisponible, demandez plutôt l'avis de Google, c'est mieux et plus rapide.", Toast.LENGTH_LONG).show();
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }

    class ListResources extends BaseAdapter
    {
        ArrayList<Categorie> mydata;
        Context context;
        ListResources(Context context)
        {
            this.context = context;
            mydata = new ArrayList<Categorie>();
            mydata.add(new Categorie(1,"Apéritifs",R.drawable.aperitifs));
            mydata.add(new Categorie(2,"Légume Sec",R.drawable.legumes));
            mydata.add(new Categorie(3,"Boissons",R.drawable.boissons));
            mydata.add(new Categorie(4,"Fruits",R.drawable.fruits));
            mydata.add(new Categorie(5,"Fast food",R.drawable.fastfood));
            mydata.add(new Categorie(6,"Fruits secs",R.drawable.corpsgras));

        }

        @Override
        public int getCount() {
            return mydata.size();
        }

        @Override
        public Object getItem(int position) {
            return mydata.get(position);
        }

        @Override
        public long getItemId(int position) {
            return position;
        }

        @Override
        public View getView(int position, View view, ViewGroup parent) {
            LayoutInflater inflater = getLayoutInflater();
            View row = inflater.inflate(R.layout.details_categorie,parent,false);
            TextView title = (TextView) row.findViewById(R.id.txt_cat);
            ImageView img = (ImageView) row.findViewById(R.id.img_cat);


            final Categorie cat = mydata.get(position);

            title.setText(cat.nom_cat);
            img.setImageResource(cat.img_cat);
            return row;
        }
    }
}
