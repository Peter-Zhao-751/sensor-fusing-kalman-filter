class Quaternions{
  private Quaternions{
    // static class, dont make instances
  }
  
  // input quat from gyro such as piegon
  public static double[] calculate(double quatW, double quatX, double quatY, double quatZ, double robotSpaceX, double robotSpaceY, double robotSpaceZ){
    double[][] rotationMatrix = new double[3][3];

    rotationMatrix[0][0] = 1.0 - 2.0 * (quatY * quatY + quatZ * quatZ);
    rotationMatrix[0][1] = 2.0 * (quatX * quatY - quatZ * quatW);
    rotationMatrix[0][2] = 2.0 * (quatX * quatZ + quatY * quatW);

    rotationMatrix[1][0] = 2.0 * (quatX * quatY + quatZ * quatW);
    rotationMatrix[1][1] = 1.0 - 2.0 * (quatX * quatX + quatZ * quatZ)
    rotationMatrix[1][2] = 2.0 * (quatY * quatZ - quatX * quatW);

    rotationMatrix[2][0] = 2.0 * (quatX * quatZ - quatY * quatW);
    rotationMatrix[2][1] = 2.0 * (quatY * quatZ + quatX * quatW);
    rotationMatrix[2][2] = 1.0 - 2.0 * (quatX * quatX + quatY * quatY);

    double[] results = new double[3];
    results[0] = rotationMatrix[0][0] * robotSpaceX + rotationMatrix[0][1] * robotSpaceY + rotationMatrix[0][2] * robotSpaceZ;
    results[1] = rotationMatrix[1][0] * robotSpaceX + rotationMatrix[1][1] * robotSpaceY + rotationMatrix[1][2] * robotSpaceZ;
    results[2] = rotationMatrix[2][0] * robotSpaceX + rotationMatrix[2][1] * robotSpaceY + rotationMatrix[2][2] * robotSpaceZ;

    return results;
  }
}
