# 🔦 BBEEMO (모스 부호 다중 감각 번역기)



BBEEMO는 사용자가 입력한 한국어 및 영문 텍스트를 모스 부호로 양방향 번역하고, 결과물을 소리, 진동, 손전등(플래시)을 이용해 시각적, 청각적, 촉각적으로 다중 감각 재생을 제공하는 안드로이드 애플리케이션입니다.

1. 언어의 경계를 허무는 다중 감각의 연결
텍스트는 눈으로만 읽어야 하지만, 삐모는 이를 소리(청각), 진동(촉각), 빛(시각)으로 바꿉
니다.
단순히 정보로 전달하는 게 아니라, 사용자가 직접 체감하게 만듭니다.

3. 가장 본질적인 소통 방식의 현대적 재해석
모스 부호는 통신 기술 중 가장 오래된 방식 중 하나지만, 가장 열악한 상황(조난, 재난
등)에서 끝까지 살아남는 본질적인 소통 수단입니다.
복잡한 현대의 통신망이 끊긴 순간에도, 삐모는 안드로이드라는 현대적 플랫폼을 빌려
가장 원초적이고 강력한 소통 방식을 사용자에게 제공합니다.

5. 모두를 위한 접근성
시각이나 청각에 제약이 있는 사용자라도 진동이나 빛을 통해 정보를 전달받을 수 있는
가능성을 열어줍니다. 아날로그적 메시지 소통방식으로 y2k 감성을 즐길 수 있습니다.

<br>

## 📸 1. 화면 구성 (Screenshots)
<img width="478" height="850" alt="image" src="https://github.com/user-attachments/assets/cd718183-10e8-4671-be5b-fb818fcc2fc3" />
<img width="477" height="851" alt="image" src="https://github.com/user-attachments/assets/70980dce-d097-4069-bb16-21cb961a0581" />

<br>
<br>
<br>

## ✨ 2. 주요 기능 (Key Features)

1. 텍스트 ↔ 모스 부호 양방향 번역:
한글 및 영문 텍스트를 모스 부호 알고리즘 규칙에 맞춰 빠르고 정확하게 변환합니다.

3. 다중 감각 재생 시스템 (Multi-sensory Playback):
모스 부호의 .(Dot)과 _(Dash)에 맞는 커스텀 사운드 재생가능합니다.
모스 부호 패턴에 따른 진동 재생가능합니다.
손전등(Torch) 플래시를 이용해 빛 패턴으로 재생가능합니다.

5. 오늘의 포츈쿠키:
하루 운세를 점쳐보세요. 물론 모스부호로 제공됩니다.

7. 사용자간 모스부호 메시지 기능:
사용자간의 모스부호로 메시지 통신이 가능합니다.

9. 모스부호 단어 연습 게임:
모스부호 철자 혹은 단어가 제시되면 한글로 번역하여 입력, 정답을 맞추는 연습게임입
니다. 모스부호 실력을 늘릴 수 있습니다.

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
  2. 기존 재생 기능을 `Schedulers.io()` (백그라운드 스레드)에서 실행시켜 메인 스레드 블로킹을 해결했습니다.
  3. 정지 기능은 `CompositeDisposable` 객체를 통해 구현했습니다. 사용자가 정지 버튼을 누르면 즉시 구독을 해제(`clear()`)합니다.


<br>

## 📂 5. 프로젝트 주요 구조 (Project Structure)
```text
📦 app/src/main/java/com/example/bbeemo_final
 ┣ 📜 MainActivity.java             # 번역 메인 화면 (언어 감지 및 번역 로직)
 ┣ 📜 SecondFavoritesActivity.java  # 결과 화면 (모스 부호 멀티미디어 재생 로직)
 ┗ 📜 EmailPasswordActivity.java    # 로그인 구현 액티비티 
