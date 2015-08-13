package com.mygdx.game;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

import java.io.*;

public class MyGdxGame extends ApplicationAdapter {
    SpriteBatch batch;

    @Override
    public void create() {
        batch = new SpriteBatch();

        test();
    }

    public void test() {
        String text =
                "Tutorial_1_1=Составляй слова, проводя пальцем по буквам.Сейчас попробуй создать слово  'СОТЫ'\n" +
                        "Tutorial_1_2=Ты можешь складывать слова справа налево. Попробуй составить слово 'ЖАЛО' справа налево\n" +
                        "Tutorial_1_3=Слова могут распологаться сверху вниз, снизу вверх, справа налево, слева направо, а также по диагонали.\n" +
                        "Tutorial_1_4=Создавая слова, ты можешь изменять направление.Составь слово 'ВОСК'\n" +
                        "Tutorial_1_5=Ты даже можешь пересекать свое собственное слово. Тем не менее, используй каждую букву только один раз. А сейчас, сложи слово 'УЛЕЙ'\n" +
                        "Tutorial_1_6=Чем длиннее окажется твоё слово, тем больше у тебя шансов получить много очков и возможность заработать Чудо-Цветок. Составь слово 'ПЧЕЛА'\n" +
                        "Tutorial_1_7=Получи Чудо-Цветы за каждое слово из пяти или более букв. Они могут быть использованы в качестве любой из букв.\n" +
                        "Tutorial_1_8=Составь слово 'СТЕБЕЛЬ'\n" +
                        "Tutorial_1_9=Из разных по длине и форме слов получаются разные Чудо-Цветы.\n" +
                        "Tutorial_1_10=Теперь ты справишься сам. Составь еще четыре слова, чтобы уровень был пройден";

        // This defaults to the default charset, which in my instance, and most probably yours is UTF-8
        byte[] bytes = new byte[0];
        try {
            bytes = text.getBytes("UTF-8");
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }

        String test = new String(bytes);
        // This is correct
        Gdx.app.log("File1", test);

        ByteArrayInputStream is = new ByteArrayInputStream(bytes);
        InputStreamReader reader = null;
        try {
            reader = new InputStreamReader(is, "UTF-8");
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }

        BufferedReader br = new BufferedReader(reader);
        StringBuilder fileContents = new StringBuilder();
        String line;
        try {
            while ((line = br.readLine()) != null) {
                fileContents.append(line + "\r\n");
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        // This is incorrect
        Gdx.app.log("File2", fileContents.toString());
    }


    @Override
    public void render() {
        Gdx.gl.glClearColor(1, 0, 0, 1);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
        batch.begin();
        batch.end();
    }
}

