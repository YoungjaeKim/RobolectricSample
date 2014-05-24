RobolectricSample
=================

AndroidStudioでのRobolectricの利用方法がバージョンごとにいろいろあり、
ググってコピペしてもうまく動かなくてハマった。
(結果的にはすごくシンプルな設定なったけど)
今後も設定方法が変わっていくとは思いますが
2014/05/24時点でのRobolectricの設定をメモっておきます。
ポイントになるコミットは下記の２つです

- [robolectric追加](https://github.com/naosim/RobolectricSample/commit/1920470baa7675d8aef71340b30e502527e6c560)
- [テスト追加](https://github.com/naosim/RobolectricSample/commit/5a2ad995e20b314232a224dd5d20306a878bb643)

## 設定方法
- プロジェクトはCompleSDKVersionをAPIレベル18以下で作る
  - RoborectricがAPIレベル19に非対応
  - 19を使う場合は、テストコードのクラス名の直前にアノテーション追加
    - @Config(emulateSdk = 18)
- build.gradleの設定
  - dependenciesにroborectricを追加
    - classpath 'org.robolectric.gradle:gradle-android-test-plugin:0.9.+'
- app/build.gradlecの設定
  - android-testのプラグイン追加
    - apply plugin: 'android-test'
  - dependenciesにtestComplie追加
    - androidTestCompile 'junit:junit:4.+'
    - androidTestCompile'org.robolectric:robolectric:2.+'
    - androidTestCompile 'com.squareup:fest-android:1.0.+'
- テストコード追加
  - app/srcの下に androidTest/javaディレクトリを作成
  - 上記javaディレクトリ内にテストコードを置く
  - テストコードはクラス名のところにアノテーションを付ける
    - @RunWith(RobolectricTestRunner.class)
  - テストメソッドに @Test を付ける
  - Assertは org.junit.Assert の方を使う
- 実行
  - ./gradlew build
  - パーミッションエラーが出たら./gradlewに実行権限を付ける
    - chmod 775 gradlew とか

## ググった結果のメモ
- RobolectricGradleTestRunnerをつくる
  - Robolectricのver2.2以下ではmanifestファイルを探す必要があるためこれを作ってる
  - 現在はRobolectricのver2.3なので不要です
- repositories に url 'https://oss.so.../snapshots/'を追加してる
  - Robolectricのver2.3のSNAPSHOTを取得するために入れてる
  - 現在はSNAPSHOTを使ってないので不要です
- テストディレクトリをsetRootする
  - androidTest配下にテストコードを配置する場合は不要です
- build.gradleでtestCompileやinstrumentTestCompileを設定する
  - いまはいらないっぽい

