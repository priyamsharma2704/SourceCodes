//
//  callbackFunctions.h
//  IM project 3
//
//  Created by cpsfaculty on 9/1/16.
//  Copyright (c) 2016 ___Ju Shen___. All rights reserved.
//

#ifndef IM_project_3_callbackFunctions_h
#define IM_project_3_callbackFunctions_h


#endif
int flag=0;
int flag2=0;
int key_press=0;
float dx,dy;
float xc,yc,zc;
float x_curr=0,y_curr=0;
float x_new,y_new;
float x_tot=0,y_tot=0,z_tot=0;

struct Vertex{
float x,y,z;
};
struct Triangle{
int v1,v2,v3;
};
struct New_list{
	float x;
	float y;
	float z;
};

vector<Vertex> v_list;
vector<Triangle>t_list;
vector<New_list>n_list;

void onKeyboard(unsigned char key, int x, int y)
{
    switch (key)
    {
        case 27:
            exit(1);
            
            break;
        case 'm':
			{
				if(flag==0)
					flag=1;
				else flag=0;
				glutPostRedisplay();
				break;
			}
        case '1':
            break;
        case '0':
            break;
        case '2':
            break;
            
        default:
            break;
    }
}

void onMouse(int button, int state, int x, int y)
{
    
    GLint specialKey = glutGetModifiers();
    switch (button) {
        case GLUT_LEFT_BUTTON:
            if (state == GLUT_DOWN) 
			{
				x_curr=x;
				y_curr=y;
                if (specialKey == GLUT_ACTIVE_SHIFT)
                {
					key_press=1;
                }
				else if(specialKey == GLUT_ACTIVE_CTRL)
                {
					key_press=2;
                }
            }
            else if (state == GLUT_UP)
            {
				for(int i =0;i<v_list.size();i++)
				{
					n_list[i].x=v_list[i].x;
					n_list[i].y=v_list[i].y;
					n_list[i].z=v_list[i].z;

				}
				x_tot=0;
				y_tot=0;
				z_tot=0;
				for(int i =0;i<v_list.size();i++)
				{
					x_tot+=n_list[i].x;
					y_tot+=n_list[i].y;
					z_tot+=n_list[i].z;					
				}
				xc=x_tot/n_list.size();
				yc=y_tot/n_list.size();
				zc=z_tot/n_list.size();
				key_press=0;
            }
            break;
            
        case GLUT_RIGHT_BUTTON:
            if (state == GLUT_DOWN)
                
                break;
            
        default:
            break;
            
    }
    
    
    glutPostRedisplay(); //This is an important function to let the window re-rendered. If you do not call this function explicitly
    //the window never get refereshed. So you should call this function in the onKeyboard event as well if you
    //want to refresh the display
    

}

void onMouseMotion(int x, int y)
{
    glutPostRedisplay(); //This is an important function to let the window re-rendered. If you do not call this function explicitly
                         //the window never get refereshed. So you should call this function in the onKeyboard event as well if you
                         //want to refresh the display
	x_new=x;
	y_new=y;
	dx=(x_new-x_curr)/100;
	dy=(y_new-y_curr)/100;
	for(int i=0;i<v_list.size();i++)
	{
		if(key_press==1)
		{
			v_list[i].x=n_list[i].x+dx;
			v_list[i].y=n_list[i].y+dy;
		}
		else if(key_press == 2)
		{
			v_list[i].x = n_list[i].x * cos(dx) + n_list[i].z * sin(dx) - xc * cos(dx) - zc * sin(dx) + xc;
			v_list[i].y = n_list[i].x * sin(dy) * sin(dx) + n_list[i].y * cos(dy) - n_list[i].z * sin(dy) * cos(dx) - xc * sin(dy) * sin(dx) - yc * cos(dy) + zc * sin(dy) * cos(dx) + yc;
			v_list[i].z = - n_list[i].x * cos(dy) * sin(dx) + n_list[i].y * sin(dy) + n_list[i].z * cos(dy) * cos(dx) + xc * cos(dy) * sin(dx) - yc * sin(dy) - zc * cos(dy) * cos(dx) + zc;		
		}
		else
		{
			v_list[i].x = n_list[i].x * cos(dx) + n_list[i].z * sin(dx);
			v_list[i].y = n_list[i].x * sin(dy) * sin(dx) + n_list[i].y * cos(dy) - n_list[i].z * sin(dy) * cos(dx);
			v_list[i].z = - n_list[i].x * cos(dy) * sin(dx) + n_list[i].y * sin(dy) + n_list[i].z * cos(dy) * cos(dx);
		}
		
	}
}




/*Define the 3D objects that want to show*/
void onDisplay() {
    glClear(GL_COLOR_BUFFER_BIT | GL_DEPTH_BUFFER_BIT);
    
    /* Below is an example of drawing a solid triangle */
    /*glColor3f(1.0, 0.0, .0); //RGB
    glBegin(GL_TRIANGLES);
    glVertex3f(-0.2, 0.18, 1.0); //point A
    glVertex3f(0.2, 0.1, 1.0); //point B
    glVertex3f(0.1, 0.3, 1.2); //point C
    glEnd();
    */
    
    /* Below is an example of drawing a mesh triangle */
    glColor3f(1.0, 1.0, 1.0);
	
	int a,b,c;
	float x=0,y=0,z=0;
	
	for(int i = 0 ; i<t_list.size();i++)
	{
		if(flag==0)
		glBegin(GL_LINE_LOOP);
		else 
		glBegin(GL_TRIANGLES);	
		a = t_list[i].v1;
		b = t_list[i].v2;
		c = t_list[i].v3;
		glVertex3f(v_list[a-1].x,v_list[a-1].y,v_list[a-1].z); //point A
		glVertex3f(v_list[b-1].x,v_list[b-1].y,v_list[b-1].z); //point B
		glVertex3f(v_list[c-1].x,v_list[c-1].y,v_list[c-1].z); //point C
		glEnd();

	}
    
	 
    /* You are suggested to create a separate function instead of drawing the triangles here, which can make your code clear*/
    /* For example you create a function called "renderAllTriangles();" */
   
    glFlush(); //clear the memory
}
