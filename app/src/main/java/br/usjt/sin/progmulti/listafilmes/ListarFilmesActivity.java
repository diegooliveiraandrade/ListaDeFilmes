package br.usjt.sin.progmulti.listafilmes;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;

import br.usjt.sin.progmulti.servicedesk.R;

/* Author: Diego Oliveira de Andrade RA: 81621341
 */

public class ListarFilmesActivity extends Activity {
    public static final String DESCRICAO =
            "br.usjt.progmulti.servicedesk.descricao";
    ArrayList<String> lista;
    Activity atividade;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_listar_filmes);
        atividade = this;
        Intent intent = getIntent();
        String chave = intent.getStringExtra(MainActivity.NOME);
        lista = buscaChamados(chave);
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this,
                android.R.layout.simple_list_item_1, lista);
        ListView listView = (ListView) findViewById(R.id.listview);
        listView.setAdapter(adapter);
        listView.setOnItemClickListener(new
                                                AdapterView.OnItemClickListener() {
                                                    @Override
                                                    public void onItemClick(AdapterView<?> parent, View view,
                                                                            int position, long id) {

                                                        Intent intent = new Intent(atividade,
                                                                DetalheFilmesActivity.class);
                                                        intent.putExtra(DESCRICAO, lista.get(position));
                                                        startActivity(intent);
                                                    }
                                                });
    }
    public ArrayList<String> buscaChamados(String chave){
        ArrayList<String> lista = geraListaFilmes();
        if (chave == null || chave.length() == 0){
            return lista;
        } else {
            ArrayList<String> subLista = new ArrayList<>();
            for(String nome:lista){
                if(nome.toUpperCase().contains(chave.toUpperCase())){
                    subLista.add(nome);
                }
            }
            return subLista;
        }
    }
    public ArrayList<String> geraListaFilmes(){
        ArrayList<String> lista = new ArrayList<>();
        lista.add("A Bússola de Ouro - 2017");
        lista.add("A Múmia - 2017");
        lista.add("Click! - 2006");
        lista.add("DeadPool - 2016");
        lista.add("Em Ritmo de Fuga - 2016");
        lista.add("Golpe Duplo - 2015");
        lista.add("Independence Day - 2016");
        lista.add("Interestelar - 2014");
        lista.add("JigSaw - 2018");
        lista.add("Kong - A Ilha da Caveira - 2017");
        lista.add("LEGO Batman - 2017");
        lista.add("Minions - 2015");
        lista.add("O Procurado - 2008");
        lista.add("Os Guardiões - 2017");
        lista.add("Planeta dos Macacos - A Guerra - 2017");
        lista.add("Sniper Americano - 2015");
        lista.add("A Rede Social - 2010");
        lista.add("A Teoria de Tudo - 2015");
        lista.add("Godzilla - 2014");
        lista.add("Golpe Duplo - 2015 ");
        lista.add("Mad Max - Estrada da Fúria - 2015");
        return lista;
    }
}