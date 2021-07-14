# News Project

### 概要
自作ライブラリである`naoko`を利用したプロジェクト

News APIを用いてニュースを取得、表示するアプリの集合体です

### 中身

#### core 
ドメイン。全てのプロジェクトの共通部分を抽出

Naokoに唯一依存しているモジュール

将来的にはRecommendation AIとかもぶち込んでみたい

#### android
アンドロイドアプリとして作成した部分

中身は、Viewを含むメインの機能を搭載した`app`モジュール、データの永続化用の`model`モジュールを含む

将来的にはbuild.gradleをKotlin DSLに入れ替えていきたい
DataStoreが落ち着いてきたらPreferenceと入れ替えしていきたい
また、利便性を向上できるようにしていきたい


### 他にサブプロジェクトする候補

- Compose for Desktop
- Ktor
- KotlinJs with React
