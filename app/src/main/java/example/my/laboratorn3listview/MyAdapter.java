package example.my.laboratorn3listview;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import java.util.List;

//Класс адептера. В классе адаптера реализуются методы, в которых разработчик указывает количество пунктов списка, данные для вывода в каждом пункте и так далее.
public class MyAdapter extends BaseAdapter {

    private List<MainActivity.Picture> list;
    private LayoutInflater inflater;
    private MainActivity mainAct;

    public MyAdapter(Context context, List<MainActivity.Picture> list, MainActivity mA) {
        this.list = list;
        inflater = LayoutInflater.from(context);
        mainAct=mA;
    }

    @Override
    public int getCount() {
        return list.size();
    }

    @Override
    public Object getItem(int position) {
        return list.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    //Метод getView() возвращает корень дерева объектов UI, которые отображают пункт списка.
    //Этот метод вызывается виджетом списка при отрисовке каждого видимого пункта списка (+ один невидимый пункт сверху и снизу для обеспечения плавности прокрутки).
    //Метод принимает три аргумента: порядковый номер списка, который запрашивается виджетом, корень дерева объектов для повторного использования
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        // 1. Проверяем, есть ли у нас пункт списка для повторного использования
        if (convertView == null)
            convertView = inflater.inflate(R.layout.list_item, parent, false);

        // 2. Получаем доступ к виджетам дерева объектов
        TextView author = convertView.findViewById(R.id.author);
        TextView title = convertView.findViewById(R.id.title);
        ImageView image = convertView.findViewById(R.id.picture);

        // 3. Меняем содержимое виджетов
        author.setText(list.get(position).getAuthor());
        title.setText("\""+list.get(position).getTitle()+"\"");
        image.setImageResource(list.get(position).getImageId());

        //Кнопка для просмотра дополнительной информации об элементе списка
        Button button = (Button) convertView.findViewById(R.id.button);
        button.setOnClickListener(new View.OnClickListener()
        {
            //При нажатии на кнопку вызывается метод главной активити, который вызывает вторую активити с дополнительной информацией о картине
            @Override
            public void onClick(View v)
            {
                mainAct.pictAct(position);
            }
        });

        // 4. Возвращаем модифицированное дерево объектов
        return convertView;
    }
}
