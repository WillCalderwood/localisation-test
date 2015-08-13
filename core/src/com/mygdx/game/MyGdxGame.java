package com.mygdx.game;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.files.FileHandle;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.utils.I18NBundle;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.Reader;
import java.util.Locale;

public class MyGdxGame extends ApplicationAdapter {
    SpriteBatch batch;
    private BitmapFont font;
    private I18NBundle bundle;

    @Override
    public void create() {
        batch = new SpriteBatch();
        font = new BitmapFont(Gdx.files.internal("font.fnt"));
        bundle = I18NBundle.createBundle(Gdx.files.internal("Local/Local"), new Locale("ru"), "UTF-8");

        // Instantiate the bundle
        bundle = new I18NBundle();

        logFileContents();
    }

    private void logFileContents() {
        // Load bundle properties from the stream with the specified encoding
        FileHandle file = Gdx.files.internal("Local/Local_ru.properties");
        Reader reader = file.reader("UTF-8");
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

        Gdx.app.log("File", fileContents.toString());
    }

    @Override
    public void render() {
        Gdx.gl.glClearColor(1, 0, 0, 1);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
        batch.begin();
        font.draw(batch, "Быстрая Игра", 20, 200);
        font.draw(batch, bundle.get("Quick_Game"), 20, 100);
//        Gdx.app.log("Translation", bundle.get("Quick_Game"));
        batch.end();
    }
}
