## **R-CNN 이란**

###  🎲컴퓨터 비전에서의 문제

* Classification
* Object Detection
* Image Segmentation
* Visual Relationship

![computer vision](https://user-images.githubusercontent.com/55940552/104691663-fafc4d00-5749-11eb-8a22-c2e8cb59a276.PNG)

#### **1. Classification**

> Single object에 대해서 object의 클래스를 분류하는 문제



* Classification : 단일 객체의 클래스 분류
* Classification + Localization : 단일 객체에 대해 객체의 위치를 Bounding box로 찾고<br> 클래스를 분류하는 문제



### **2. Object Detection**

> Multiple objects에서 각각의 object에 대해 Classification+Localization을 수행하는 문제



* **1-stage detector**

  1. 전체 이미지에 대해 Convolution Network를 통해 classification, <br>box regression(localization)을 수행한다.   

     

* **2-stage detector**

  > **2-stage Detector 대표 CNN model** : R-CNN, Fast R-CNN, Faster R-CNN 

  1. RoI(Region of Interest)를 추출한다(object가 있을만한 영역)
  2. 각 영역들을 Convolution Network를 통해 classification, box regression을 수행한다.

   

### **3. Image Segmentation**

> Multiple objects에서 각각의 object의 위치에 대해 edge로 찾는 문제 





###  **🎲R-CNN Process** 

1. Image 입력
2. **Selective search** 알고리즘에 의해 **regional proposal output** 약 2000개 추출
3. 추출한 **regional proposal output**을 동일 input size로 만들어주기 위해 **wrap** 수행
   * Convolution Layer에는 Input size가 고정되지 않음
   * 마지막 FC Layer에서의 Input size가 고정이므로 <br>Convolution Layer에 대한 output size도 동일해야 한다.
   * 따라서 Convolution Layer에 입력에서부터 동일한 Input size로 넣어줘서 <br> output size를 동일하게 하는 것이다.
4. 2000개의 **wraped image**를 각 **CNN Model**에 넣는다.
5. 각각의 **Convolution** 결과에 대해 **Classification**을 진행하여 결과를 얻는다.

   



### **🎲R-CNN Module**

* **Region Proposal** : Object가 있을만한 영역을 찾는 모듈
* **CNN** : 각각의 영역으로부터 고정된 크기의 Feature Vector를 뽑아낸다.
* **SVM** : Classification을 위한 선형 지도학습 모델
  * **softmax를 쓰지 않는 이유** : CNN fine-tuning을 위한 학습 데이터가 시기상<br> 많지 않아서 softmax를 적용시키면 오히려 성능이 낮아진다.



***

출처 

[프라이데이 티스토리](https://ganghee-lee.tistory.com/35)

