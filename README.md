# 🔦 BBEEMO (모스 부호 다중 감각 번역기)



BBEEMO는 사용자가 입력한 한국어 및 영문 텍스트를 모스 부호로 양방향 번역하고, 결과물을 소리, 진동, 손전등(플래시)을 이용해 시각적, 청각적, 촉각적으로 다중 감각 재생을 제공하는 안드로이드 애플리케이션입니다.

<br>

## 📸 1. 화면 구성 (Screenshots)
<img width="478" height="850" alt="image" src="https://github.com/user-attachments/assets/cd718183-10e8-4671-be5b-fb818fcc2fc3" />
<img width="477" height="851" alt="image" src="https://github.com/user-attachments/assets/70980dce-d097-4069-bb16-21cb961a0581" />

<br>
<br>
<br>

## ✨ 2. 주요 기능 (Key Features)

* **텍스트 ↔ 모스 부호 양방향 번역:** 한글 및 영문 텍스트를 모스 부호 알고리즘 규칙에 맞춰 빠르고 정확하게 변환합니다.
* **다중 감각 재생 시스템 (Multi-sensory Playback):**
  * `MediaPlayer API`: 모스 부호의 단점(Dot)과 장점(Dash)에 맞는 커스텀 사운드 재생
  * `Vibrator API`: 모스 부호 패턴에 따른 진동 인터페이스 제공
  * `Camera2 API`: 손전등(Torch) 플래시를 이용해 빛 패턴으로 재생
* **비동기 제어 및 즉시 정지 (Asynchronous & Stop Logic):** 
  * RxJava를 활용하여 UI 스레드 멈춤 없이 안정적인 백그라운드 재생 스케줄링.
  * 실행 중 언제든지 사용자가 ‘정지’ 기능을 통해 즉각적으로 진동, 소리, 빛을 멈출 수 있습니다.

<br>

## 🛠 3. 기술 스택 (Tech Stack)

* **Language:** Java
* **UI/UX:** XML 기반 Android UI
* **Architecture / Config:** Min SDK 30, Target SDK 34
* **Asynchronous Control:** RxJava3, RxAndroid (`Completable`, `CompositeDisposable`)
* **Hardware API:** `CameraManager`, `Vibrator`

<br>

## 🔥 4. 트러블 슈팅 (Troubleshooting)

### 스레드 블로킹(ANR) 현상 해결 및 즉시 정지(Stop) 기능 구현
* **문제 상황:** 모스 부호를 재생할 때 부호 간의 간격을 주기 위해 `Thread.sleep()` 메서드를 사용했습니다. 하지만 이 방식은 안드로이드의 **메인 스레드(UI 스레드) 자체를 멈춰버려**, 긴 부호가 재생되는 동안 앱의 모든 버튼(정지 버튼 포함)과 터치가 먹통이 되는 버그(ANR)를 발생시켰습니다.
* **해결 방안 및 과정:**
  1. 백그라운드 스레드에서 모스 부호를 재생하기 위해 **RxJava를 도입**했습니다.
  2. 기존 재생 기능을 `Completable` 스트림 모나드로 분리하여 `Schedulers.io()` (백그라운드 스레드)에서 실행시켜 메인 스레드 블로킹을 해결했습니다.
  3. 정지 기능은 `CompositeDisposable` 객체를 통해 구현했습니다. 사용자가 정지 버튼을 누르면 즉시 구독을 해제(`clear()`)합니다.


<br>

## 📂 5. 프로젝트 주요 구조 (Project Structure)
```text
📦 app/src/main/java/com/example/bbeemo_final
 ┣ 📜 MainActivity.java             # 번역 메인 화면 (언어 감지 및 번역 로직)
 ┣ 📜 SecondFavoritesActivity.java  # 결과 화면 (모스 부호 멀티미디어 재생 로직)
 ┗ 📜 EmailPasswordActivity.java    # 로그인 구현 액티비티 
