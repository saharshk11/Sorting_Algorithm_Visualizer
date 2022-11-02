float[] values;
int arrayAccesses;
float startTime;
int gap;
float shrink_factor = 1.3;
boolean sorted = false;

void setup(){
  size(800, 500);
  arrayAccesses = 0;
  values = new float[width];
  gap = values.length;
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

void draw(){
  display();
  if(!sorted){
    gap /= shrink_factor;
    if(gap <= 1){
      gap = 1;
      sorted = true;
    }
    for(int i = 0; i+gap < values.length; i++){
      if(values[i] > values[i+gap]){
        switchVals(values, i, i+gap);
        sorted = false;
        arrayAccesses += 2;
      }
    }
  } else{
    noLoop();
  }
}

float[] switchVals(float[] arr, int pos1, int pos2){
  float hold = arr[pos1];
  arr[pos1] = arr[pos2];
  arr[pos2] = hold;
  arrayAccesses += 3;
  return arr;
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
