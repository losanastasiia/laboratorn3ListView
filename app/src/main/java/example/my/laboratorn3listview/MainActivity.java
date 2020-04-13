package example.my.laboratorn3listview;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;

//Главная активити
public class MainActivity extends AppCompatActivity {

    ListView list;

    @RequiresApi(api = Build.VERSION_CODES.N)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_main);

        List<Picture> data = createList();
        list = findViewById(R.id.list);

        // Создаем объект адаптера
        MyAdapter adapter = new MyAdapter(this, data, this);

        // Передаем его виджету списка
        list.setAdapter(adapter);


    }

    //метод, который запускает вторую активити PictureActivity и передает туда информацию об элементе списка
    public void pictAct(int i){
        Intent intent = new Intent(MainActivity.this, PictureActivity.class);
        //передаем данные второй активити (PictureActivity)
        intent.putExtra("author", ((Picture)list.getItemAtPosition(i)).getAuthor());
        intent.putExtra("title", ((Picture)list.getItemAtPosition(i)).getTitle());
        intent.putExtra("information", ((Picture)list.getItemAtPosition(i)).getInformation());
        intent.putExtra("image", ((Picture)list.getItemAtPosition(i)).getImageId());

        startActivity(intent); //запускаем PictureActivity
    }

    @RequiresApi(api = Build.VERSION_CODES.N)
    private List<Picture> createList() { //метод для заполнения списка данными

        List<Picture> pictures = new ArrayList<>();

        // записываем данные в список
        pictures.add(new Picture("Иван Айвазовский",
                "Девятый вал",
                "«Девятый вал» — одна из самых знаменитых картин российского художника-мариниста армянского происхождения Ивана Айвазовского, хранится в Русском музее в Санкт-Петербурге. Написана в 1850 году. Живописец изображает море после очень сильного ночного шторма и людей, потерпевших кораблекрушение.",
                R.drawable.picture1));
        pictures.add(new Picture("Сальвадор Дали",
                "Постоянство памяти",
                "«Постоянство памяти» — одна из самых известных картин художника Сальвадора Дали. Находится в Музее современного искусства в Нью-Йорке с 1934 года. Известна также как «Мягкие часы», «Твердость памяти» или «Стойкость памяти» или «Течение времени» или «Время».",
                R.drawable.picture2));
        pictures.add(new Picture("Исаак Левитан",
                "Золотая осень",
                "«Золотая осень» — пейзаж русского художника Исаака Левитана, написанный в 1895 году. Принадлежит Государственной Третьяковской галерее. Размер картины — 82 × 126 см. Левитан начал работу над картиной осенью 1895 года, когда он жил в усадьбе Горка в Тверской губернии; там же были написаны первые этюды.",
                R.drawable.picture3));
        pictures.add(new Picture("Иван Шишкин",
                "Утро в сосновом лесу",
                "«Утро в сосновом лесу» — картина русских художников И. И. Шишкина и К. А. Савицкого. Савицкий написал медведей, но коллекционер П. М. Третьяков стёр его подпись, так что автором картины часто указывается один Шишкин.",
                R.drawable.picture4));
        return pictures;
    }


    //Класс элемента списка - картины, содержит информацию об авторе, названии, описании и изображение картины
    public class Picture {
        private String author;
        private String title;
        private String information;
        private int imageId;

        //конструктор
        public Picture(String author,String title, String information, int imageId) {
            this.author = author;
            this.title = title;
            this.information = information;
            this.imageId = imageId;
        }

        //геттеры и сеттеры
        public String getAuthor() {
            return author;
        }

        public void setAuthor(String author) {
            this.author = author;
        }

        public String getTitle() {
            return title;
        }

        public void setTitle(String title) {
            this.title = title;
        }

        public String getInformation() {
            return information;
        }

        public void setInformation(String information) {
            this.information = information;
        }

        public int getImageId() {
            return imageId;
        }

        public void setImageId(int imageId) {
            this.imageId = imageId;
        }
    }
}

