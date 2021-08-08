# Java 付録
* Java5からの追加された機能でよく使う機能を紹介
  * Java5
    * 拡張for
      * 従来のfor文より、コンパクトに書くことができるのが、拡張for文です。

      従来のfor文
      ```java
      String[] array = new String[]{"hoge", "fuga", "foo", "bar"};
      for (int i = 0; i < array.length(); i++>) {
          System.out.println(array[i]);
      }
      ```
      拡張for文
      ```java
      for (String str : array) {
          System.out.println(str);
      }
      ```
    * 総称型(ジェネリクス)
      * Java5以前は、ListやMapには、Objectとして追加されるためなんでも詰め込めるようになっていました。
      そのため、取得するたびにキャストしないといけないデメリットがあった。
      ```java
      final List list = new ArrayList();
      list.add("文字列");
      list.add(123);
      list.add(false);
      list.add(new Date());

      for (Object obj : list) {
          if (obj instanceof String) {
              final String str = (String) obj;
              System.out.println("Stringです。 obj = " + str);
          } else {
              System.out.println("Stringではないです。");
          }
      }
      ```
      * 総称型が追加されたことで、ListやMapに追加する型が明確となる。
        * 型が明確となるため、キャストする手間が省ける。
        ```java
        final List<String> list = new ArrayList<String>();
        list.add("文字列1");
        list.add("文字列2");
        list.add("文字列3");

        for (String str : list) {
            System.out.println("Stringです。 obj = " + str);
        }
        ```
        * 指定した型以外は、登録できないようになる。
        ```java
        final List<String> list = new ArrayList<String>();
        list.add("文字列");
        list.add(123);  // Stringではないのでコンパイルエラーになる
        list.add(false); // Stringではないのでコンパイルエラーになる
        ```
    * 列挙型(enum)
      * 複数の定数を一つのクラスにまとめて定義できる。
      * valueOfやvaluesなどのメソッドが標準で使える。
      * メソッドを定義できる。
  * Java7
    * try-with-resources
      * リソースのクローズを処理が終わったタイミング自動的にcloseしてくれる。ただし、AutoCloseableインタフェースおよびそのサブインタフェースであるCloseableインタフェースの実装クラスに限られる。

      従来のリソース解放
      ```java
      public void hoge() throws IOException {
          File file = new File("ファイルパス");
          InputStream is = null;
          try {
              is = new FileInputStream(file);
              // 処理
          } catch (FileNotFoundException e) {
              e.printStackTrace();
          } finally {
              if (is != null) {
                  is.close();
              }
          }
      }
      ```
      try-with-resourcesを使った解放
      ```java
      File file = new File("ファイルパス");
      try (InputStream is = new FileInputStream(file)) {
          // 処理
      } catch (IOException e) {
        e.printStackTrace();
      }
      ```
    * 例外のマルチキャッチ
    * Objects
    * Path,Files
  * Java8
    * ラムダ式
      * 関数型インターフェースの実装を簡潔に記述

      従来
      ```java
      Runnable runner = new Runnable() {
          public void run() {
              System.out.println("Hello Lambda!");
          }
      };
      runner.run();
      ```
      ラムダ式
      ```java
      Runnable runner = () -> {
        System.out.println("Hello Lambda!");
      };
      runner.run();
      ```
    * Stream
      * イテレーションの拡張API

      従来
      ```java
      List<Integer> integerList = Arrays.asList(1, 2, 3, 4, 5);
          for (Integer i : integerList) {
              if (i % 2 == 0) {
              System.out.println(i);
          }
      }
      ```
      Stream
      ```java
      List<Integer> integerList = Arrays.asList(1, 2, 3, 4, 5);
      integerList.stream().filter(i -> i % 2 == 0).forEach(System.out::println);
      ```
    * Optional
      * Optionalで値をラップして、 `その値がnullかもしれない` ことを表現する

      従来
      ```java
      String fuga = getFuga();
      if (fuga != null) {
          System.out.println(fuga.length());
      }
      ```
      Optionalを使用した場合
      ```java
      Optional<String> fugaOtional = Optional.ofNullable(getFuga());
      fugaOtional.ifPresent(fuga -> System.out.println(fuga.length()));
      ```
    * 日時API
      * Java7までに使用していた日時クラス(Date、Calender)と別物(ただし、変換は可能)
      * LocalDateTime や ZonedDateTimeなどが追加されている。
  * Java9
    * 静的ファクトリ
      * Collectionに静的ファクトリメソッドが追加されました。
        1. List.of
        2. Map.of
        3. Set.of
      * 静的ファクトリメソッドで作成されたCollectionは不変Collectionとなります。
      * Toipc
        * Arrays.asListとの違い
          * Arrays.asListで作成したListは、変更可能だか、List.ofで作成したListは、不変である。
  * Java10
    * var(ローカル変数の型推論)
      * ローカル変数を定義するの型定義を `var` と書くことで省略できる。
      * プロジェクトによって異なるのでプロジェクトのルールに従って使ってください。
      ```java
      var num = 1; // int か Integer なのかわからないので int などのプリミティブ型を使うときは、 varを使用しない方が良いと思われる。
      ```