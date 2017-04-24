//
//  main.cpp
//  OpenGL1
//
//  Created by cpsfaculty on 3/1/16.
//  Copyright (c) 2016 ___Ju Shen___. All rights reserved.
//

#include <iostream>
#ifdef WIN32
#include <windows.h>
#endif

#include <stdlib.h>
#include <iostream>
#include <fstream>

#include<glut.h>


#define X .525731112119133606
#define Z .850650808352039932

int WINDOW_WIDTH = 600;
int WINDOW_HEIGHT = 600;




int i;


/*light data*/
//GLfloat light_diffuse[] = { 1.0, 1.0, 1.0, 1.0 };  /* Grey diffuse light. */
//GLfloat light_specular[] = { 1.0, 1.0, 1.0, 1.0 }; /*Specular light*/
//GLfloat light_ambient[] = { .1, .1, .1, 1.0 }; /*Ambient color */
GLfloat light_position[] = { 0.0, 0.0, 5.0, 1.0 };  /* Infinite light location. */
GLfloat angle = 100;
GLfloat light_direction[] = { .0, .0, -1.0 };
GLfloat light_x = .0f;
GLfloat light_y = .0f;
GLfloat light_z = 5.0f;
int phong = 0;

/*material data*/
GLfloat material_color1[] = { 0.1, 0.7, .0, 1.0 }; //ambient 1
GLfloat material_color2[] = { 1.0, 0.0, .0, 1.0 }; //ambient 2
GLfloat material_color3[] = { .0, 1.0, 0.0, 1.0 }; //specular
GLfloat material_ambient[] = { .5, .5, .5, 1.0 };
GLfloat low_sh[] = {5.0};
GLfloat material_specular[] = { .2, .2, .2, 1. };

/* Define data */
int mouse_down = 0; //Represent the left mouse key is clicked down
int change_mode = 0; //0 means change eye position; 1 means change focus position
int current_x = 0, current_y = 0;
static GLdouble ex = .0, ey = 0.0, ez = 5.0, upx = .0, upy = 1.0, upz = .0, ox = 0.0, oy = 0.0, oz;

/*Projection matrix mode*/
int projection = 0; //0 - parallel; 1 - perspective

/*Shading Mode*/
int shading = 1;

void initialize()
{
    /* Use depth buffering for hidden surface elimination. */
    glEnable(GL_DEPTH_TEST);
    glViewport(0, 0, (GLint)WINDOW_WIDTH, (GLint)WINDOW_HEIGHT);
    glLightfv(GL_LIGHT0, GL_POSITION, light_position);
    glLightfv(GL_LIGHT0, GL_SPOT_CUTOFF, &angle);
    
    printf("oz %.f\n", oz);
    
}


void onDisplay()
{
    
    //for each iteration, clear the canvas
    glClear(GL_COLOR_BUFFER_BIT | GL_DEPTH_BUFFER_BIT);
    
    
    /*glMatrixMode(GL_PROJECTION);*/
    glMatrixMode(GL_PROJECTION); //define the camera matrix model
                                 //
    glLoadIdentity(); //generate a matrix
    
    
    if (projection == 0) //parallel projection
    {
        
      glOrtho(-3, 3, -3, 3, -100, 100);//geneterat intrinsics
                                        //Mp = I * [6/640, 0, 0, +3 * ratio_x;]
                                        //         [0,    6/480, 0, -3 * ratio_y]
                                        //         [0,    0,     1,     0]

        
    }
    else  //perspective
        gluPerspective(60.0,  (GLfloat)WINDOW_WIDTH / (GLfloat)WINDOW_HEIGHT, .1, 100.0);
    
    /* About Shading */
    if(shading == 1)
    {
        light_position[0] = light_x;
        light_position[1] = light_y;
        light_position[2] = light_z;
        glLightfv(GL_LIGHT0, GL_POSITION, light_position);
        glMaterialfv(GL_FRONT, GL_AMBIENT, material_color3);
        glEnable(GL_LIGHT0);
        glEnable(GL_LIGHTING);
        
        if(phong == 1)
        {
            
            glLightf(GL_LIGHT0, GL_SPOT_EXPONENT, 0.2);
            glMaterialfv(GL_FRONT, GL_AMBIENT, material_color1);
            glMaterialfv(GL_FRONT, GL_SPECULAR, material_color3);
            glMaterialfv(GL_FRONT, GL_SHININESS, low_sh);
        }else{
        }
        

    }
    else{
        glDisable(GL_LIGHT0);
        glDisable(GL_LIGHTING);
    }
    
    
    
    glMatrixMode(GL_MODELVIEW);
    glLoadIdentity(); //generate a matrix M_m = I
    
    gluLookAt(ex, ey, ez, ox, oy, ox, upx, upy, upz);
             //ex, ey, ez - camera center position
             //ox, oy, oz - camera orientation, specify the point your k
            // eye is looking at.
             //upx, upy, upz - positive y direction
    
    
   
    //glMaterialfv(GL_FRONT, GL_DIFFUSE, material_color1);
    glPushMatrix();
    glTranslated(0.0, 0.0, 0.0); //generate a matrix
    glColor3f(0, 0.8, 0);
    glutSolidTeapot(1);
    glEnd();
    
    
  
    glutSwapBuffers();//display the buffer
    
    
    
    
}




//****************************************************************************
//Name: onMouse
//Description: The mouse event callback
//Function calls: buttonPushed, glutPostResdisplay
//Preconditions: x,y is a valid point
//Postconditions: The mouse event is handled
//Parameters: GLint x, y, the mouse position
//				button, the mouse buttons used
//				state, the properties of the mouse
//				GLUT_UP, GLUT_DOWN, GLUT_LEFT_BUTTON
//				GLUT_RIGHT_BUTTON,
//Returns: Nothing
void onMouse(int button, int state, int x, int y)
{
    
    GLint specialKey = glutGetModifiers();
    switch (button) {
        case GLUT_LEFT_BUTTON:
            if (state == GLUT_DOWN) {
                mouse_down = 1;
                current_x = x;
                current_y = y;
                if (specialKey == GLUT_ACTIVE_SHIFT)
                {
                    change_mode = 1;
                }
                else
                {
                    change_mode = 0;
                }
            }
            else if (state == GLUT_UP)
            {
                mouse_down = 0;
            }
            break;
            
        case GLUT_RIGHT_BUTTON:
            if (state == GLUT_DOWN)
                
                break;
            
        default:
            break;
            
    }
    
}

void onResize(GLint w, GLint h)
{
    //glViewport (0, 0, (GLsizei) w, (GLsizei) h);
    //glMatrixMode(GL_PROJECTION);
    //glLoadIdentity();
    //gluPerspective (65.0, (GLfloat) w/(GLfloat) h, 1.0, 100.0);
    
}


void onIdle()
{
    
}


void onMouseMotion(int x, int y)
{
    if (mouse_down == 1)
    {
        if (change_mode == 0)
        {
            ex += static_cast<float>(x - current_x) / 100.f;
            ey += static_cast<float>(y - current_y) / 100.f;
        }
        else{
            ox += static_cast<float>(x - current_x) / 100.f;
            oy += static_cast<float>(y - current_y) / 100.f;
        }
        
        current_x = x;
        current_y = y;
    }
    glutPostRedisplay();
}

void onKeyboard(unsigned char key, int x, int y)
{
    switch (key)
    {
        case 27:
            exit(1);
            
            break;
        case 'p':
            projection = (projection == 0) ? 1 : 0;
            glutPostRedisplay();
            break;
        case 'z':
            ez += 0.2;
            glutPostRedisplay();
            printf("Z: %.3f\n", ez);
            break;
        case 'x':
            ez -= 0.2;
            glutPostRedisplay();
            printf("Z: %.3f\n", ez);
            break;
            
        case 's':
            shading = (shading == 0)?1:0;
            glutPostRedisplay();
            break;
            
        case 'o':
            phong = (phong == 0)?1:0;
            glutPostRedisplay();
            break;
        default:
            break;
    }
}

void processSpecialKeys(int key, int x, int y)
{
    switch (key)
    {
        case 27 :      break;
        case 100 :
            light_x -= 1.2;
            glutPostRedisplay();

            break;
        case 102:
            light_x += 1.2;
            glutPostRedisplay();
            break;
        case 101   :
            light_y += 1.2;
            glutPostRedisplay();
            break;
        case 103 :
            light_y -= 1.2;
            glutPostRedisplay();
            break;
    }
    
}


int main(int argc, char** argv)
{
    //Initialization functions
    glutInit(&argc, argv);
    glutInitDisplayMode(GLUT_DOUBLE | GLUT_RGB | GLUT_DEPTH);
    glutInitWindowSize(640, 480);
    glutInitWindowPosition(0, WINDOW_HEIGHT / 2);
    glutCreateWindow("Draw Teapot");
    
    initialize(); //optional
    
    //Call-back functions
    glutDisplayFunc(onDisplay);
    glutKeyboardFunc(onKeyboard);  //waitKey(500)
    glutSpecialFunc(processSpecialKeys);
    glutMouseFunc(onMouse); //mouse click
    glutMotionFunc(onMouseMotion); //mouse movement
    glutReshapeFunc(onResize);
    glutIdleFunc(onIdle); //run something in the backgrond
    
    
    //Infinite Loop
    glutMainLoop(); //== while(1)
    return 1;
}
