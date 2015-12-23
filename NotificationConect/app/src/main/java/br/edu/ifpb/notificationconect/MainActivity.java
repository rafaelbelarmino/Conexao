package br.edu.ifpb.notificationconect;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.app.Activity;

public class Logar extends Activity {
    private EditText editUsu, editSenha;
    private AlertDialog.Builder alert;
    private Button Acessar;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        etUsuario= (EditText) findviewById(R.id.editUsuario);
        etSenha= (EditText) findviewById(R.id.editSenha);
        btAcessar=(Button).findviewById(R.id.btAcessar);

        btAcessar.setOnClickListener(new View.OnClickListener()


    }

    public void onClick(View v) {
        String urlPost="http://localhost/MainActivity.java"
        String urlGet="http://localhost/conexao/MainActivity.java?Usuario="+etUsuario.getText().toString()+"&senha="+etSenha
         ArrayList<NameValuePair>  parametrosPost = new ArrayList<NameValuePair>();
        parametrosPost.add(new BasicNameValuePair("usuario",etUsuario.get.Text().toString()));
        parametrosPost.add(new BasicNameValuePair("senha",etSenha.get.Text().toString()));
        String respostaRetornada = null;
        try {
            respostaRetornada=  HttpService.executaHttpPost(urlPost, parametrosPost);
            String resposta = respostaRetornada.toString();
            resposta = resposta.replaceAll("\\s+","");
            if(resposta.equals("1"))
            Toast.makeText(Logar.this, "Usuario Valido Parabéns ", Toast.LENGHT_LONG);
            else
                Toast.makeText(Logar.this, "Erro: Usuarui Invalido " + erro, Toast.LENGHT_LONG

        }
         catch(Exception erro) {
             Toast.makeText(Logar.this, "Erro: ", Toast.LENGHT_LONG);


         }


    }

    Button notificacaoButton = (Button)findViewById(R.id.notificationButton);
        notificacaoButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.i("NotificationWearApp", "Clique no botão da Notificação");
                int notificationId = 001;

                NotificationCompat.Builder notificationBuilder =
                        new NotificationCompat.Builder(MainActivity.this)
                                .setSmallIcon(R.drawable.light)
                                .setContentTitle("Title")
                                .setContentText("Android Wear Notification");

                NotificationManagerCompat notificationManager =
                        NotificationManagerCompat.from(MainActivity.this);

                notificationManager.notify(notificationId, notificationBuilder.build());

                Uri som = RingtoneManager.getDefaultUri(RingtoneManager.TYPE_NOTIFICATION);
                Ringtone toque = RingtoneManager.getRingtone(v.getContext(), som);
                toque.play();
            }
        });

        Button asyncTaskButton = (Button)findViewById(R.id.asyncTaskButton);
        asyncTaskButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.i("NotificationWearApp", "Clique no botão da AsyncTask");

                EditText nomeEditText = (EditText) findViewById(R.id.nomeEditText);
                String nome = nomeEditText.getText().toString();

                LoginAsyncTask loginAsyncTask = new LoginAsyncTask(v.getContext());
                String[] valores = {nome};

                loginAsyncTask.execute(valores);
            }
        });
    }
}