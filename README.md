<b>
  <p>
    Скачать: 
    <a href="https://github.com/GrishaninVyacheslav/reddit-pagging/releases/download/pre-release/reddit_pagging.apk">reddit_pagging.apk</a>
  <p/>
  <p>
    Стек технологий: Retrofit, Kotlin Coroutines, Room, Fragments.
  <p/>
</b>
Приложение, демонстрирующее реализацию пагинации популярных
постов reddit. Состоит из одного экрана с бесконечным списком постов
с Reddit. Загрузка списка осуществляется не постранично, а
динамически: новые посты подгружаются, пока пользователь
прокручивает список. По мере прокручивания списка, просмотренные
посты кэшируются с помощью Room. Посты из кэша отображаются и в
случае отсутствия интернета. 
<p align="center">
  <img src="preview.jpg" width="197" height="426">
</p>
