package br.eti.urbano.mobile.exemploretrofit2.activities;

import android.os.Build;
import android.os.Bundle;
import android.support.annotation.RequiresApi;
import android.support.v7.app.AppCompatActivity;
import android.telecom.Call;
import android.widget.ListView;
import android.widget.SimpleAdapter;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import br.eti.urbano.mobile.exemploretrofit2.R;
import br.eti.urbano.mobile.exemploretrofit2.boostrap.APIClient;
import br.eti.urbano.mobile.exemploretrofit2.model.Users;
import br.eti.urbano.mobile.exemploretrofit2.resource.UserResource;

public class UsersActivity extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_post);

        /*Pega a referencia do ENDPOINT e do converter(gson)
         * */
        Retrofit retrofit = APIClient.getClient();

        //Faz o 'bind' da instância do retrofit com interface
        //que contém as operações (GET,POST,PUT,DELETE)
        UserResource postResource = retrofit.create(UserResource.class);

        //Faz a chamada do serviço
        Call<List<Users>> get = postResource.get();

        get.enqueue(new Callback<List<Post>>() {
            @Override
            public void onResponse(Call<List<Users>> call, Response<List<Users>> response) {
                //Se deu certo executa este método
                List<Users> users = response.body();
                users.forEach(p-> Log.i  ("senai",p.toString()));
            }

            @Override
            public void onFailure(Call<List<Users>> call, Throwable t) {
                //Houve erro é executado este método.
            }
        });

    }
}
    }