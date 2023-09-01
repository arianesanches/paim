
public class PointwiseTransform extends Object {

 /**
  * oi
 * Question 2.1 Contrast reversal
 */
 static public ImageAccess inverse(ImageAccess input) {
  int nx = input.getWidth();
  int ny = input.getHeight();
  ImageAccess output = new ImageAccess(nx, ny);
  double value = 0.0;
  for (int x=0; x<nx; x++)
  for (int y=0; y<ny; y++) {
   value = input.getPixel(x, y);
   value = 255 - value;
   output.putPixel(x, y, value);}
  return output; 
 }
	
 /**
 * Question 2.2 Stretch normalized constrast
 */
 static public ImageAccess rescale(ImageAccess input) {
  int nx = input.getWidth();
  int ny = input.getHeight();
  double max = input.getMaximum();
  double min = input.getMinimum();
  ImageAccess output = new ImageAccess(nx, ny);
  double value = 0.0;
  double a = 255/(max - min);
  for (int x=0; x<nx; x++)
  for (int y=0; y<ny; y++){
   value = input.getPixel(x, y);
   value = a*(value - min);
   output.putPixel(x, y, value);}
  return output; 
 }

 /**
 * Question 2.3 Saturate an image
 */
	
 static public ImageAccess saturate(ImageAccess input) {
  int nx = input.getWidth();
  int ny = input.getHeight();
  ImageAccess output = new ImageAccess(nx, ny);
  double value = 0.0;
  for (int x=0; x<nx; x++)
  for (int y=0; y<ny; y++){
  value = input.getPixel(x, y);
   if (value > 10000) {
    value = 10000;}
  output.putPixel(x, y, value);}
  return output;
 }
	
 /**
 * Question 4.1 Maximum Intensity Projection
 */
 static public ImageAccess zprojectMaximum(ImageAccess[] zstack) {
  int nx = zstack[0].getWidth();
  int ny = zstack[0].getHeight();
  int nz = zstack.length;
  ImageAccess output = new ImageAccess(nx, ny);
  for (int i=0; i<nz; i++)
  for (int x=0; x<nx; x++)
  for (int y=0; y<ny; y++){
   double value = output.getPixel(x, y) + zstack[i].getPixel(x, y);
   output.putPixel(x, y, value);}
  double M = output.getMaximum();
  for (int x=0; x<nx; x++)
  for (int y=0; y<ny; y++) {
   double value = output.getPixel(x, y)*255/M;
   output.putPixel(x, y, value);}
  return output;
 }
  
 /**
 * Question 4.2 Z-stack mean
 */
 static public ImageAccess zprojectMean(ImageAccess[] zstack) {
  int nx = zstack[0].getWidth();
  int ny = zstack[0].getHeight();
  int nz = zstack.length;
  ImageAccess output = new ImageAccess(nx, ny);
  for (int i=0; i<nz; i++)
  for (int x=0; x<nx; x++)
  for (int y=0; y<ny; y++){
   double value = output.getPixel(x, y) + zstack[i].getPixel(x, y);
   output.putPixel(x, y, value);}
  for (int x=0; x<nx; x++)
  for (int y=0; y<ny; y++) {
   double value = output.getPixel(x, y)/nz;
   output.putPixel(x, y, value);}
  return output;
 }
	
 }