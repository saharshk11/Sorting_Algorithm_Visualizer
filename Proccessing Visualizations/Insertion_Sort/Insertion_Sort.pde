float[] values;
int arrayAccesses;
int i = 1;
float startTime;

void setup(){
  size(800, 500);
  arrayAccesses = 0;
  values = new float[width];
  float[] temp = new float[width];
  for(int i = 0; i < temp.length; i++){
    temp[i] = height*(float)i/width+1;
  }
  for(int i = 0; i < values.length; i++){
    int add = (int)random(temp.length);
    while(contains(values, temp[add])){
      add = (int)random(temp.length);
    }
    values[i] = temp[add];
  }
  startTime = millis();
}

void draw(){ //<>//
   display();
   if(i < values.length){
      int insertPosition = i;
      while(insertPosition > 0 && values[insertPosition-1] > values[i]){
          insertPosition--;
          arrayAccesses += 2;
      }
      values = insert(values, insertPosition, i);
      i++;
   } else {
    noLoop(); //<>//
  }
}

float[] insert(float[] arr, int insertPosition, int i){
    if(insertPosition == i){
        return arr;
    }
    float[] answer = new float[arr.length+1];
    for(int j = 0; j < insertPosition; j++){
        answer[j] = arr[j];
        arrayAccesses++;
    }
    answer[insertPosition] = arr[i];
    for(int j = insertPosition; j < arr.length; j++){
        if(j != i){
            answer[j+1] = arr[j];
        }
        arrayAccesses++;
    }
    float[] replace = new float[arr.length];
    for(int j = 0, k = 0; j < answer.length; j++){
        if(answer[j] != 0){
            replace[k] = answer[j];
            k++;
        }
    }
    answer = replace;
    return answer;
}

void display(){
  background(0);
  text("Array Accesses: " + arrayAccesses, 10, 20);
  text("Display Time: " + ((millis()-startTime)/1000), 10, 40);
  for(int i = 0; i < values.length; i++){
    stroke(255);
    line(i, height, i, height-values[i]);
  }
}

boolean contains(float[] arr, float val){
  for(float i: arr){
    if(i == val){
      return true;
    }
  }
  return false;
}
