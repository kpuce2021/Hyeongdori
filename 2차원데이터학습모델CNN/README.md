## 인공신경망   

### CNN Model 

***

   

### CNN(Convolutional Neural Network) 이란?   

* 이미지를 인식하기 위해 패턴을 찾는데 유용한 네트워크
* 데이터에서 직접 학습, 패턴 사용으로 이미지를 분류한다.
* 자율주행 자동차, 얼굴인식과 같은 **객체인식**, **Computer vision**에서 사용되고 있다.   



### **CNN 용어**

1. **Convolution(합성곱)**

   > 필터가 적용될 영역과 개발자가 임의로 지정한 Filter를 적용하여<br> 이미지의 feature map을 만들 수 있다.
   >
   > Filter(Kernel)의 구성에 따라 이미지의 특징을 추출 가능

2. **Filter(Kernel)**

   > 여러 개 필터를 이용하여 이미지의 세부 특징을 추출하여 학습이 가능하다.
   >
   > **CNN**은 신경망에서 학습을 통해 자동으로 적합한 필터를 생성해 준다.

3. **Channel**

   * Multi Channel CNN에서 주의할 점
     * Input Data의 채널 수와 Filter의 채널 수는 같아야 한다.
     * Input Data의 채널 수와 관계없이 Filter의 개수만큼 Output Data가 추출된다.

   > 하나의 Color 이미지는 R, G, B 3개의 채널로 구성되어 있다.   

4. **Padding**

   * 옵션
     * valid : padding 0을 뜻한다, 입력보다 출력의 크기가 작아진다.
     * same : padding이 존재, 입력과 출력의 크기가 같다.

   > Convolution 시 입력 데이터보다 출력 데이터가 작아지는 것을 방지하는 방법
   >
   > 0으로 둘러 쌓여 특징이나 분해능에는 영향을 미치지 않는다.

5. **Pooling**

   * 처리 방법

     * Max Pooling

     * Average Pooling

     * **Min Pooling(CNN 에서 주로 사용)**

       -> 노이즈 감소, 속도 향상, 영상 분별력 증가 

   > 이미지 크기를 계속 유지한 채 FC(Fully Connected) 레이어로 가게 되면 연산량이 <br> 기하급수적으로 늘어난다.
   >
   > 크기도 줄이면서 특정 **feature**를 강조해야 할 경우 **Pooling Layer**에서 수행한다.

   



### **CNN 전체 구조**   



#### **1. 특징 추출 단계(Feature Extraction)**

* Convolution과 Pooling을 반복하면서 이미지의 **Feature**를 추출한다.

> Convolution Layer : 필터를 통해 이미지 특징 추출
>
> Pooling Layer : 특징 강화, 이미지 크기 감소 시킴 

#### **2. 이미지 분류 단계(Classification)**

> Flatten Layer : 데이터 타입을 FC 네트워크 형태로 변경, 입력 데이터의 Shape 변경만 수행
>
> Softmax Layer : Classification 수행

   

### **파라미터 설정**   



* **Convolution Filter** 개수
  * 각 Layer에서의 연산시간과 양을 비교적 일정하게 유지하며 시스템 균형을 맞추는 것이 좋다.
  * 보통 Pooling Layer를 거치면 1/4로 출력이 감소
  * Convolution Layer 결과인 Feature map의 개수를 4배 정도 증가 시키면 된다.
* **Filter Size**
  * 작은 필터를 여러 개 중첩 시키면 원하는 특징을 더 돋보이게 할 수 있으며 연산량이 감소됨
  * 대부분 CNN은 3 by 3 size를 중첩해서 사용
* **Padding** 여부
  * Convolution 수행 전, 입력 데이터 주변을 특정 픽셀 값으로 채워 늘리는 것 
  * 사용 시 입력 이미지 크기를 줄이지 않을 수 있다.
* **Stride**
  * Filter의 이동 간격을 조절하는 파라미터
  * 값이 커지면 결과 데이터의 사이즈가 작아지게 된다.

   

### **결론**

> Convolution과 Pooling을 반복적으로 사용하면서 불변하는 특징을 찾고,<br> 그 특징을 입력 데이터로 Fully-Connected 신경망에 전송하여 Classification을 수행한다.

   

### **CNN 종류**   



### 1. LeNet   

* 손글씨 숫자를 인식하는 네트워크

* 합성곱 계층과 풀링 계층을 반복, 마지막으로 완전연결 계층을 거치면서 결과를 출력

* 시그모이드 사용, 서브 샘플링으로 중간 데이터의 크기가 작아진다.

  **시그모이드(Sigmoid) 함수** : Binary Classification에 적절한 함수

  * 일정 값을 기준으로 0과 1로 구분하여 분류하는 방식
  * 딥러닝에서 특정 임계치를 초과할 때만 활성화 된다.
  * Activation Function 중의 하나로 구분되는 함수

   

### 2. AlexNet

* 합성곱 계층과 풀링 계층을 거듭하며 마지막으로 완전연결 계층을 거쳐 결과를 출력

* 활성화 함수로 ReLU를 사용

  **ReLU 함수** : Hidden layer를 활성화 시키는 함수

  * 시그모이드 함수를 사용하지 않는다.
  * 0보다 작은 값이 나오면 0, 큰 값이 나오면 그대로 반환하는 함수
  * 내부 **hidden layer**에는 **ReLU**를 적용, 마지막 **output layer**에서만 **Sigmoid 함수** 적용시<br> 이전에 비해 정확도가 훨씬 상승함

* LRN이라는 국소적 정규화를 실시하는 계층 이용

* 드롭아웃을 사용한다.

   

### 3. VGGNet

* 합성곱 계층과 풀링 계층으로 구성되는 기본적인 CNN
* 비중있는 층인 **합성곱 계층**, **완전연결 계층**을 모두 16개, 혹은 19개로 심화한 특징을 가짐
* 층의 깊이에 따라 VGG16, VGG19로 구분한다.
* 3 by 3 matrix 필터를 사용한 **합성곱 계층**을 연속적으로 거친다.
* **합성곱 계층**을 2~4회 연속으로 풀링 계층을 두어 크기를 절반으로 줄이는 처리를 반복한다.
* 마지막에 **완전연결 계층**을 통과시켜 결과를 출력한다.

   

### 4. GoogleNet

* 깊이(세로) 뿐만 아니라 폭(가로)도 깊은 특징을 가지고 있다.

* 인셉션 구조를 하나의 빌딩 블록으로 사용한다.

  **인셉션 구조**

  * 크기가 다른 필터와 풀링을 여러 개 적용하여 그 결과를 결합한다.

* 1 by 1 matrix 크기의 필터를 사용한 합성곱 계층을 많은 곳에서 사용한다.

  * 1 by 1 합성곱 연산은 채널 쪽 크기를 줄이는 것
  * 매개변수 제거와 고속 처리에 기여한다.

   

### 5. ResNet

* 보다 더 층을 깊게 쌓기 위해 **스킵 연결**을 도입한다.

  **스킵 연결**

  * 입력 데이터를 합성곱 계층을 건너뛰어 출력에 바로 더하는 구조

  * 역전파 시 스킵 연결이 신호 감쇠를 막아주어 층이 깊어져도 <br>학습을 효율적으로 할 수 있도록 해줌

    

***

출처 

[CNN이란?  - 개발자 블로그](https://gruuuuu.github.io/machine-learning/cnn-doc/#)   

[CNN 종류 - 개발자 깃허브](https://wjddyd66.github.io/dl/CNN-(2)-CNN%EC%A2%85%EB%A5%98/)

