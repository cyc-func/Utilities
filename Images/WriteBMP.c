#include <stdio.h>
#include <stdlib.h>


#define WIDTH  256
#define HEIGHT 320


void drawbmp(char *, int[WIDTH][HEIGHT], int[WIDTH][HEIGHT], int[WIDTH][HEIGHT]);


int main(void)
{
  int r[WIDTH][HEIGHT];
  int g[WIDTH][HEIGHT];
  int b[WIDTH][HEIGHT];

  for(int i = 0; i < WIDTH; i++)
  {
    for(int j = 0; j < HEIGHT; j++)
    {
      r[i][j] = 244;
      g[i][j] = 66;
      b[i][j] = 191;
    }
  }
  drawbmp("hahlol.bmp", r, g, b);

  return 0;
}

void drawbmp(char *filename, int r[WIDTH][HEIGHT], int g[WIDTH][HEIGHT], int b[WIDTH][HEIGHT])
{
  FILE *fout;

  unsigned int headers[13];

  unsigned int extraBytes;
  unsigned int paddedImageSize;

  extraBytes = 4 - ((WIDTH * 3) % 4);
  if(extraBytes == 4) extraBytes = 0;
  paddedImageSize = ((WIDTH * 3) + extraBytes) * HEIGHT;

  headers[0] = paddedImageSize + 54;
  headers[1] = 0;
  headers[2] = 54;
  headers[3] = 40;
  headers[4] = WIDTH;
  headers[5] = HEIGHT;

  headers[7]  = 0;
  headers[8]  = paddedImageSize;
  headers[9]  = 0;
  headers[10] = 0;
  headers[11] = 0;
  headers[12] = 0;

  fout = fopen(filename, "wb");

  fprintf(fout, "BM");

  for(int i = 0; i <= 5; i++)
  {
    fprintf(fout, "%c", headers[i] & 0x000000FF);
    fprintf(fout, "%c", (headers[i] & 0x0000FF00) >> 8);
    fprintf(fout, "%c", (headers[i] & 0x00FF0000) >> 16);
    fprintf(fout, "%c", (headers[i] & (unsigned int) 0xFF000000) >> 24);
  }

  fprintf(fout, "%c", 1);
  fprintf(fout, "%c", 0);
  fprintf(fout, "%c", 24);
  fprintf(fout, "%c", 0);

  for(int i = 7; i <= 12; i++)
  {
    fprintf(fout, "%c", headers[i] & 0x000000FF);
    fprintf(fout, "%c", (headers[i] & 0x0000FF00) >> 8);
    fprintf(fout, "%c", (headers[i] & 0x00FF0000) >> 16);
    fprintf(fout, "%c", (headers[i] & (unsigned int) 0xFF000000) >> 24);
  }

  for(int y = HEIGHT - 1; y >= 0; y--)
  {
    for(int x = 0; x < WIDTH; x++)
    {
      fprintf(fout, "%c", b[x][y]);
      fprintf(fout, "%c", g[x][y]);
      fprintf(fout, "%c", r[x][y]);
    }

    if(extraBytes)
    {
      for(int i = 0; i < extraBytes; i++)
      {
        fprintf(fout, "%c", 0);
      }
    }
  }

  fclose(fout);
}
