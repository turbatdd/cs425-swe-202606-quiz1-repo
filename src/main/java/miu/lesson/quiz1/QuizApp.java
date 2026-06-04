package miu.lesson.quiz1;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.TypeAdapter;
import com.google.gson.stream.JsonReader;
import com.google.gson.stream.JsonWriter;
import miu.lesson.quiz1.model.Account;
import miu.lesson.quiz1.service.AccountService;
import miu.lesson.quiz1.service.account.AccountServiceImpl;

import java.io.IOException;
import java.time.LocalDate;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class QuizApp {
    private final AccountService accountService;

    public QuizApp() {
        this.accountService = new AccountServiceImpl();
    }


    public static void main(String[] args) {
        QuizApp app = new QuizApp();
        Account acc = new Account(1, "Turbat", "Davaakhishigt", "(424) 123-0009", "dagar@m.as", "1 N Street");
        app.createAccount(acc);

    }

    private void createAccount(Account account) {
        System.out.println("Hello, New Account created!");
//        var data = accountService.createAccount(account);

//        System.out.println(data);
    }

    private void printAccounts() {
        var data = accountService.getAllAccounts();

        Gson gson = new GsonBuilder()
                .setPrettyPrinting()
                .registerTypeAdapter(LocalDate.class, new TypeAdapter<LocalDate>() {
                    @Override
                    public void write(JsonWriter out, LocalDate value) throws IOException {
                        if (value == null) {
                            out.nullValue();
                        } else {
                            out.value(value.toString()); // Out: "2026-06-03"
                        }
                    }

                    @Override
                    public LocalDate read(JsonReader in) throws IOException {
                        if (in.peek() == com.google.gson.stream.JsonToken.NULL) {
                            in.nextNull();
                            return null;
                        }
                        return LocalDate.parse(in.nextString());
                    }
                })
                .create();
        String jsonOutput = gson.toJson(data);

        System.out.println("Log");
        System.out.println("--- Account List (Sorted by Age Descending) ---");
        System.out.println(jsonOutput);
    }
}
