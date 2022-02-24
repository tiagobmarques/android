package br.com.alura.agenda.database;

import android.content.Context;

import androidx.annotation.NonNull;
import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;
import androidx.room.TypeConverters;
import androidx.room.migration.Migration;
import androidx.sqlite.db.SupportSQLiteDatabase;

import br.com.alura.agenda.database.converter.ConversorCalender;
import br.com.alura.agenda.database.dao.AlunoDAO;
import br.com.alura.agenda.model.Aluno;

@Database(entities = {Aluno.class}, version = 4, exportSchema = false)
@TypeConverters({ConversorCalender.class})
public abstract class AgendaDataBase extends RoomDatabase {

    public static final String AGENDA_DB = "agenda.db";

    public abstract AlunoDAO getRoomAlunoDAO();

    public static AgendaDataBase getInstance(Context context) {
        return Room.databaseBuilder(context, AgendaDataBase.class, AGENDA_DB)
                .allowMainThreadQueries()
//                .fallbackToDestructiveMigration()
                .addMigrations(new Migration(1, 2) {
                    @Override
                    public void migrate(@NonNull SupportSQLiteDatabase database) {
                        database.execSQL("ALTER TABLE aluno ADD COLUMN sobrenome TEXT");
                    }
                }, new Migration(2, 3) {
                    @Override
                    public void migrate(@NonNull SupportSQLiteDatabase database) {
                        database.execSQL("CREATE TABLE IF NOT EXISTS `Aluno_novo` (`id` INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL, `nome` TEXT, `telefone` TEXT, `email` TEXT)");
                        database.execSQL("INSERT INTO Aluno_novo(id,nome,telefone,email) SELECT id, nome, telefone, email FROM Aluno");
                        database.execSQL("DROP TABLE Aluno");
                        database.execSQL("ALTER TABLE Aluno_novo RENAME TO Aluno");
                    }
                }, new Migration(3, 4) {
                    @Override
                    public void migrate(@NonNull SupportSQLiteDatabase database) {
                        database.execSQL("ALTER TABLE aluno ADD COLUMN momentoDeCadastro integer");
                    }
                })
                .build();
    }
}
