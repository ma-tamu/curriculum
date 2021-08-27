 問1 Javaで使用できる修飾子を全て選択してください。
1. public  2. protected 3. private 4. static
5. final 6. abstract 7.transient 8.synchronized

問2 次のプログラムを穴埋めして、 NULL と出力されるものを選択してください。
```java
01:public class App {
02:  public static void main(String[] args) {
03:    // 穴埋め
04:    System.out.println(obj);
05:  }
06:}
```
1. Object obj = null;
2. Object obj;
3. var obj = false;
4. var obj = "null";
5. 選択肢に回答がない。

問3 次のプログラムをStreamを使用したプログラムに変換してください。
```java
01:public class App {
02:  public static void main(String[] args) {
03:    final List<String> list = Arrays.asList("hoge", "fuga", "foo", "bar");
04:    for(final String s : list) {
05:      System.out.println(s);
06:    }
07:  }
08:}
```

問4 次のプログラムの実行結果を選択肢から選択してください。
```java
01:public class App {
02:  public static void main(String[] args) {
03:    final var str = "hoge"；
04:    if (str == "hoge") {
05:      System.out.println("str = hoge");
06:      return;
07:    }
08:    System.out.pirntln("str != hoge")
09:  }
10:}
```
1. "str = hoge" と出力される。
2. "str = hoge"<br/>"str != hoge" と出力される。
3. "str != hoge" と出力される。
4. コンパイルエラーになる。

問5 次のプログラムを穴埋めして、 123 と出力してください。
```java
01:public class App {
02:  public static void main(String[] args) {
03:    final var map = Map.of(
04:      "key1", "1",
05:      "key2", "2",
06:      "key3", "3"
07:    );
08:    // 穴埋め
09:    System.out.println(str);
10:  }
11:}
```

問6 次のプログラムを try-with-resources を使用したプログラムに変換してください。
```java
01:public class App {
02:  public static void main(String[] args) throws IOException {
03:    final var file = new File("ファイルパス");
04:    InputStream is = null;
05:    try {
06:      is = new FileInputStream(file);
07:      // 処理
08:    } catch (final IOException e) {
09:      throw e;
10:    } finally {
11:      if (Objects.nonNull(is)) {
12:        is.close();
13:      }
14:    }
15:  }
16:}
```

問7 下記のプログラムを実行した結果を選択肢から選択してください。
```java
01:public class App {
02:  public static void main(String[] args) {
03:    final var opt = Optional.ofNullable(hoge());
04:    System.out.println(opt.get());
05:  }
06:}
```
1. hogeメソッドの結果がコンソールに出力される。
2. hogeメソッドがnullを返した場合にExceptionが発生する。
3. コンパイルエラーになる。

問8 下記のプログラムを実行した結果を選択肢から選択してください。
```java
01:public class App {
02:  public static void main(String[] args) {
03:    final var str = """
04:              You can write
05:              two line string.
06:              """;
07:    System.out.println(str);
08:  }
09:}
```
1. You can write two line string. と出力される。
2. You can write<br />two line string. と出力される。
3. コンパイルエラーになる。
4. コンパイルは通るが実行するとエラーになる

問9 下記のプログラムを実行した結果を選択肢から選択してください。
```java
01:public class App {
02:  public static void main(String[] args) {
03:    final var _str = "hoge";
04:    System.out.println(_str);
05:  }
06:}
```
1. hoge と出力される。
2. コンパイルエラーになる。
3. コンパイルは通るが実行するとエラーになる。

問10 Java8以降で追加された機能を記載してください。
