package br.com.rusneymaia.rusneymaia.Banco;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

public class BancoController {
    private SQLiteDatabase db;
    private CriaBanco banco;
    public BancoController(Context context) {
        banco = new CriaBanco(context);
    }

    public String insereDadoUsuario(String nome, String telefone, String email, String senha){
        ContentValues valores;
        long resultado;
        db = banco.getWritableDatabase();
        valores = new ContentValues();
        valores.put(CriaBanco.NOME1, nome);
        valores.put(CriaBanco.TELEFONE1, telefone);
        valores.put(CriaBanco.EMAIL1, email);
        valores.put(CriaBanco.SENHA1, senha);
        resultado = db.insert(CriaBanco.TABELA1, null, valores);
        db.close();
        if (resultado == -1)
            return "Erro ao inserir registro";
        else
            return "Registro Inserido com sucesso";
    }

    public Cursor recuperarSenhaUsuario(String email) {
        Cursor cursor;
        String[] campos =  { CriaBanco.NOME1, CriaBanco.SENHA1 };
        String where = CriaBanco.EMAIL1 + "=" + email;
        db = banco.getReadableDatabase();
        cursor = db.query(CriaBanco.TABELA1, campos, where, null, null, null, null, null);
        if(cursor != null) {
            cursor.moveToFirst();
        }
        db.close();
        return cursor;
    }

    public String insereDadoAgendamento(String dia, String horario, String cliente) {
        ContentValues valores;
        long resultado;
        db = banco.getWritableDatabase();
        valores = new ContentValues();
        valores.put(CriaBanco.DIA2, dia);
        valores.put(CriaBanco.HORARIO2, horario);
        valores.put(CriaBanco.CLIENTE2, cliente);
        resultado = db.insert(CriaBanco.TABELA2, null, valores);
        db.close();
        if (resultado == -1)
            return "Erro ao inserir registro";
        else
            return "Registro Inserido com sucesso";
    }
}