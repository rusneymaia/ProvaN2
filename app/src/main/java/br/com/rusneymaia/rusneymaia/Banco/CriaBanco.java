package br.com.rusneymaia.rusneymaia.Banco;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class CriaBanco extends SQLiteOpenHelper {
    public static final String NOME_BANCO = "banco.db";
    public static final String TABELA1 = "usuarios";
    public static final String ID1 = "_id";
    public static final String NOME1 = "nome";
    public static final String EMAIL1 = "email";
    public static final String TELEFONE1 = "telefone";
    public static final String SENHA1 = "senha";
    public static final String TABELA2 = "agendamentos";
    public static final String ID2 = "_id";
    public static final String DIA2 = "dia";
    public static final String HORARIO2 = "horario";
    public static final String CLIENTE2 = "cliente";

    private static final int VERSAO = 1;

    public CriaBanco(Context context){
        super(context, NOME_BANCO, null, VERSAO);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String sql1 = "CREATE TABLE" + TABELA1 + "("
                + ID1 + "integer primary key autoincrement,"
                + NOME1 + "text,"
                + EMAIL1 + "text,"
                + TELEFONE1 + "text"
                + SENHA1 + "text"
                +")";
        String sql2 = "CREATE TABLE" + TABELA2 + "("
                + ID2 + "integer primary key autoincrement,"
                + DIA2 + "text,"
                + HORARIO2 + "text"
                + CLIENTE2 + "text"
                +")";
        db.execSQL(sql1);
        db.execSQL(sql2);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS" + TABELA1);
        db.execSQL("DROP TABLE IF EXISTS" + TABELA2);
        onCreate(db);
    }
}