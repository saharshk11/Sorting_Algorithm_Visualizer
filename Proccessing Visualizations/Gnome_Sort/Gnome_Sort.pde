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

void draw(){
  display();
  if(i < values.length){
    for(int j = i; j > 0; j--){
      if(values[j-1] > values[j]){
        switchVals(values, j, j-1);
        arrayAccesses += 2;
      }
    }
    i++;
  } else {
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
