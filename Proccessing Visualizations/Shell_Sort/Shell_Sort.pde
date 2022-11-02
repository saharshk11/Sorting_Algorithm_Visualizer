float[] values;
int arrayAccesses;
int gap;
int i;
float startTime;
int[] gap_sequence = new int[0];

void setup(){
  size(800, 500);
  arrayAccesses = 0;
  values = new float[width];
  gap = values.length/2;
  i = gap;
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
  for(int power = 1, add = 2*(values.length/((int)Math.pow(2, power+1)))+1; add != 1; power++, add = 2*(values.length/((int)Math.pow(2, power+1)))+1){
    gap_sequence = append(gap_sequence, add);
  }
  gap_sequence = append(gap_sequence, 1);
  startTime = millis();
  //display();
  
  //for(int gap: gap_sequence){
  //  for(int i = 0; i + gap < values.length; i++){
  //    if(values[i] > values[i+gap]){
  //      switchVals(values, i, i+gap);
  //    }
  //  }
  //}
  //display();
}

void draw(){
  display();
  if(gap > 0){ //<>//
    if(i < values.length){
      float temp = values[i];
      arrayAccesses++;
      int j;
      for (j = i; j >= gap && values[j - gap] > temp; j -= gap){
        values[j] = values[j - gap];
        arrayAccesses += 2;
      }
      values[j] = temp;
      i++;
    } else {
      gap /= 2;
      i = gap;
    }
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
