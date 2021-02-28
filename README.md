<h1 align="center">Welcome to KrepesMultiPlatform 👋</h1>
<p>
  <a href="#" target="_blank">
    <img alt="License: MIT" src="https://img.shields.io/badge/License-MIT-yellow.svg" />
  </a>
  <a href="https://twitter.com/Gosunet" target="_blank">
    <img alt="Twitter: Gosunet" src="https://img.shields.io/twitter/follow/Gosunet.svg?style=social" />
  </a>
</p>

Because everyone needs a Kotlin Multiplatform library to share crepes recipes ! #bzh

This is a sample project to show an implementation of a Kotlin Multiplatform library with Compose.

The purpose is to share a "business" module to get and transform crepe recipes.
Then used the module in an Android, iOS, Desktop and web app.

## Library Used
- [Ktor](https://ktor.io/learn/) for the asynchronous http client.
- [kotlinx.serialization](https://github.com/Kotlin/kotlinx.serialization).
- [Koin for multiplatform](https://doc.insert-koin.io/#/setup/koin_mp) for dependency injection 🆕
- [Coroutines](https://kotlinlang.org/docs/reference/coroutines-overview.html).
- [Ktlint](https://github.com/pinterest/ktlint) as Kotlin linter.
- [MockK](https://mockk.io/) for mocking when testing shared library.

#### Android and Desktop App
- [Jetpack Compose](https://developer.android.com/jetpack/compose) in the sample android app for creating the ui.
- [Navigation](https://developer.android.com/guide/navigation/) for the navigation in the android app.
- [Jetpack Compose for Desktop](https://www.jetbrains.com/lp/compose/) 🆕
- [Coil](https://github.com/chrisbanes/accompanist/tree/main/coil) for image loading
- [Lottie for compose](http://airbnb.io/lottie/#/android-compose) 🆕

#### iOS App
- [SwitfUi](https://developer.apple.com/xcode/swiftui/) in the iOS sample App.
- [Swinject](https://github.com/Swinject/Swinject) for dependency injection in the iOS sample.

## Author

👤 **Gosunet**

* Twitter: [@Gosunet](https://twitter.com/Gosunet)
* Github: [@Gosunet](https://github.com/Gosunet)

## Show your support

Give a ⭐️ if this project helped you!

***
_This README was generated with ❤️ by [readme-md-generator](https://github.com/kefranabg/readme-md-generator)_
