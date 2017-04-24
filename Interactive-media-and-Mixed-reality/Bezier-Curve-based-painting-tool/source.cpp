#include <opencv2/highgui/highgui.hpp>
#include <iostream>
#include<stdio.h>
#include <opencv2/core/core.hpp>
#include <opencv2/imgproc/imgproc.hpp>
#include <vector>

using namespace cv;
using namespace std;

vector<Point>pts;	//to store 4 point clicks
vector<Point>center_pts;
vector<Scalar>color_vec;
vector<int>thickness;
Point temp_a,temp_b;
float data[4][4]= {{-1,3,-3,1},{3,-6,3,0},{-3,3,0,0},{1,0,0,0}};	
Mat canvas(400,400 ,CV_8UC3);	//image to draw slpines
Mat matrix_AB;
Mat M_Hermite(4,4,CV_32FC1,&data);
Mat G_Hermite(4,2,CV_32FC1);//32F is floating type and C1 means 1 channel	
double val=3.0;	//position of mouse click is closer than 3 pixel to an existing point
int sel= -1;
int flag=-1;
int in_sqr=-1;
int color=0;
int x1,y11,x2,y2,x3,y3,x4,y4,diff_x,diff_y;
char c;
int thick=1;


void onMouse(int event, int x, int y, int flags, void *param)
{
	//everytime mouse button down CV_LBUTTONDOWN
	//push the location into points
	//
	//Point p1,p2;
	if(event == CV_EVENT_LBUTTONDOWN)	//push the points into vector
	{
		for(int i =0 ; i<pts.size();i++)
		{
			double dist = pow((double)x-pts[i].x,2)+pow((double)y-pts[i].y,2) ;
			dist = pow(dist,0.5);
			if (dist<val)
			{
				sel = i;
				break;
			}

		}
		
		if(sel >-1)	//your current mouse click is close to one existing point 
		{
			pts[sel].x=x;
			pts[sel].y=y;
		}
		else if(in_sqr==-1)
		{
			pts.push_back(Point(x,y));
			int size = pts.size()/4;
			if(size>color_vec.size())
			{
				color_vec.push_back(Scalar(0,0,0));
				thickness.push_back(1);
			}
		}
		if(in_sqr>-1)
		{
			temp_a=Point(x,y);
			flag=in_sqr;
			x1 = pts[4*in_sqr].x;
			y11 = pts[4*in_sqr].y;

			x2 = pts[4*in_sqr+1].x;
			y2 = pts[4*in_sqr+1].y;

			x3 = pts[4*in_sqr+2].x;
			y3 = pts[4*in_sqr+2].y;

			x4 = pts[4*in_sqr+3].x;
			y4 = pts[4*in_sqr+3].y;
		}
		printf("hi :%d\n",pts.size());

	}
	else if(event == CV_EVENT_RBUTTONDOWN)	//remove the latest point
	{
		if(pts.size()>0)
		pts.pop_back();	//remove the top/latest point		
	}
	else if(event == CV_EVENT_LBUTTONUP)
	{ 
		sel =-1;
		in_sqr=-1;		
		temp_b=Point(x,y);
		if(flag>-1)
		{
				diff_x=temp_b.x-temp_a.x;
				diff_y=temp_b.y-temp_a.y;
				pts[flag*4]=Point((x1+diff_x),(y11+diff_y));
				pts[flag*4+1]=Point((x2+diff_x),(y2+diff_y));
				pts[flag*4+2]=Point((x3+diff_x),(y3+diff_y));
				pts[flag*4+3]=Point((x4+diff_x),(y4+diff_y));
				flag=-1;
		}
	}

	//mouse moving event
	if(sel>-1)
	{
		pts[sel].x=x;
		pts[sel].y=y;
	}
	

	//check mouse current location by comparing it with the square of all splines
	
	int spline_num=pts.size()/4;
	int j;
	for(int i=0;i<spline_num;i++)
	{
		j=4*i;
			
		G_Hermite.ptr<float>(0)[0]=pts[j].x;			//1st row
		G_Hermite.ptr<float>(0)[1]=pts[j].y;

		G_Hermite.ptr<float>(1)[0]=pts[j+1].x;			//2nd row
		G_Hermite.ptr<float>(1)[1]=pts[j+1].y;

		G_Hermite.ptr<float>(2)[0]=pts[j+2].x;			//3rd row
		G_Hermite.ptr<float>(2)[1]=pts[j+2].y;

		G_Hermite.ptr<float>(3)[0]=pts[j+3].x;			//4th row
		G_Hermite.ptr<float>(3)[1]=pts[j+3].y;

		
		matrix_AB = M_Hermite * G_Hermite;
		int x_new=matrix_AB.ptr<float>(0)[0] * pow(0.5,3) + matrix_AB.ptr<float>(1)[0] * pow(0.5,2) + matrix_AB.ptr<float>(2)[0] * pow(0.5,1) + matrix_AB.ptr<float>(3)[0];
		int y_new = matrix_AB.ptr<float>(0)[1] * pow(0.5,3) + matrix_AB.ptr<float>(1)[1] * pow(0.5,2) + matrix_AB.ptr<float>(2)[1] * pow(0.5,1) + matrix_AB.ptr<float>(3)[1];
		
		if((x >= x_new-15/2 && x<=x_new+15/2) && (y >= y_new-15/2 && y<=y_new+15/2))
		{
			in_sqr=i;
			break;
		}
		else
		{
			in_sqr=-1;
		}	
	}
	
}
void drawSpline()
{
	int spline_num=pts.size()/4;
	int j;
	for(int i=0;i<spline_num;i++)
	{
		//take out four points from pts
		//try to use matrix in the slides to compute [ax,bx,cx,dx ; ay,by,cy,dy]
		//for (t=0t<.01;t++)
		
			 j=4*i;
			
		G_Hermite.ptr<float>(0)[0]=pts[j].x;			//1st row
		G_Hermite.ptr<float>(0)[1]=pts[j].y;

		G_Hermite.ptr<float>(1)[0]=pts[j+1].x;			//2nd row
		G_Hermite.ptr<float>(1)[1]=pts[j+1].y;

		G_Hermite.ptr<float>(2)[0]=pts[j+2].x;			//3rd row
		G_Hermite.ptr<float>(2)[1]=pts[j+2].y;

		G_Hermite.ptr<float>(3)[0]=pts[j+3].x;			//4th row
		G_Hermite.ptr<float>(3)[1]=pts[j+3].y;

		//To draw control lines
		line(canvas,pts[j],pts[j+1],Scalar(200,200,200),1,8,0);
		line(canvas,pts[j+2],pts[j+3],Scalar(200,200,200),1,8,0);
		
		 matrix_AB = M_Hermite * G_Hermite;
		 
		//Draw the spline on screen based on Matrix_AB
		for(double t=0.0;t<=1.0;t+=0.001)
		{			
			int x = matrix_AB.ptr<float>(0)[0] * pow(t,3) + matrix_AB.ptr<float>(1)[0] * pow(t,2) + matrix_AB.ptr<float>(2)[0] * pow(t,1) + matrix_AB.ptr<float>(3)[0];
			int y = matrix_AB.ptr<float>(0)[1] * pow(t,3) + matrix_AB.ptr<float>(1)[1] * pow(t,2) + matrix_AB.ptr<float>(2)[1] * pow(t,1) + matrix_AB.ptr<float>(3)[1];
			circle(canvas,Point(x,y),1,color_vec[i],thickness[i]);//will draw a cricle around x & y			
		}

		int x=matrix_AB.ptr<float>(0)[0] * pow(0.5,3) + matrix_AB.ptr<float>(1)[0] * pow(0.5,2) + matrix_AB.ptr<float>(2)[0] * pow(0.5,1) + matrix_AB.ptr<float>(3)[0];
		int y = matrix_AB.ptr<float>(0)[1] * pow(0.5,3) + matrix_AB.ptr<float>(1)[1] * pow(0.5,2) + matrix_AB.ptr<float>(2)[1] * pow(0.5,1) + matrix_AB.ptr<float>(3)[1];
					
		if(in_sqr==i)
		{
			rectangle(canvas,Point(x-15/2,y-15/2),Point(x+15/2,y+15/2),Scalar(00,200,00),2,8);	
		}
		else
			rectangle(canvas,Point(x-15/2,y-15/2),Point(x+15/2,y+15/2),Scalar(200,200,200),2,8);
	}	
}

void drawPoints()
{
	for(int i = 0; i<pts.size();i++)
	{
		circle(canvas,pts[i],1,Scalar(0,0,255),2);		
	}	
}
void drawLine()
{
	line(canvas,pts[0],pts[1],Scalar(0,0,255),1,8,0);
}

int main(int argc, char** argv)
{
	//for all iterations,draw all spline from scratch (x)
	//or only draw the current spline
	//or you draw spline after point click

	namedWindow("test");
	setMouseCallback("test",onMouse);	//tell the window to use onMouse function
	while(1)
	{
		canvas= Scalar(255,255,255);
		drawPoints();//to make it interactive  : to draw for every iteration.
		drawSpline();
		imshow("test",canvas);
		 c = waitKey(1);
		if(c==27)
			break;
		else if(in_sqr!=-1)
		{
			if(c=='b' || c=='B')
			{
				color_vec[in_sqr]= Scalar(255,0,0);
			}
			if(c=='r' || c=='R')
			{
				color_vec[in_sqr]= Scalar(0,0,255);
			}
			if(c=='p' ||c=='P')
			{
				color_vec[in_sqr]= Scalar(147,20,255);
			}
			if(c=='g'||c=='G')
			{
				color_vec[in_sqr]= Scalar(0,255,0);
			}
			if(c=='y'||c=='Y')
			{
				color_vec[in_sqr]= Scalar(0,255,255);
			}
			if(c=='i' ||c=='I')
			{
				if(thickness[in_sqr]<5)
					thickness[in_sqr]++;
				else
					thickness[in_sqr]=5;				
			}
			if(c=='d' ||c=='D')
			{
				if(thickness[in_sqr]>0)
					thickness[in_sqr]--;
				else
					thickness[in_sqr]=1;				
			}
		}
		else if(c == 's' ||c=='S')
			imwrite("D:\\canvas.jpg", canvas);
	}
	return 1;
}
