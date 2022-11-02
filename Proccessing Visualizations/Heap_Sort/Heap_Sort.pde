float[] values;
int j;
int i;
int n;
int arrayAccesses;
float startTime;

void setup(){
  frameRate(100);
  size(800, 500);
  arrayAccesses = 0;
  values = new float[width];
  n = values.length;
  j = n/2-1;
  i = n-1;
  float[] temp = new float[width];
  for(int i = 0; i < temp.length; i++){
    temp[i] = height*(float)i/width+1;
  }
  for(int i = 0; i < n; i++){
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
  if(j >= 0){
    values = heapify(values, n, j);
    j--;
  } else if(i >= 0){
      values = switchVals(values, i, 0);
      arrayAccesses += 2;
      values = heapify(values, i, 0);
      i--;
  } else {
    noLoop();
  }
}

float[] heapify(float[] arr, int n, int i){
    arrayAccesses += 4;
    int largest = i;
    int l = 2*i + 1;
    int r = 2*i + 2;

    if(l < n && arr[l] > arr[largest]){
        largest = l;
    }
    if(r < n && arr[r] > arr[largest]){
        largest = r;
    }
    if(largest != i){
        arr = switchVals(arr, i, largest);
        heapify(arr, n, largest);
    }
    return arr;
}

void display(){
  background(0);
  text("Array Accesses: " + arrayAccesses, 10, 20);
  text("Display Time: " + ((millis()-startTime)/1000), 10, 40);
  for(int i = 0; i < n; i++){
    stroke(255);
    line(i, height, i, height-values[i]);
  }
}

float[] switchVals(float[] arr, int pos1, int pos2){
  float hold = arr[pos1];
  arr[pos1] = arr[pos2];
  arr[pos2] = hold;
  arrayAccesses += 3;
  return arr;
}

boolean contains(float[] arr, float val){
  for(float i: arr){
    if(i == val){
      return true;
    }
  }
  return false;
}
