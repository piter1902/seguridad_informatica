#include <iostream>
#include <fstream>
#include <cstring>

using namespace std;

const int SIZE = 200;

int main(int argc, char *argv[]){
   if(argc == 3){
	ifstream check;
	char fileName[SIZE];
	strncpy(fileName,argv[1],SIZE);
	check.open(fileName);
	if( check.fail()) {
		ofstream out;
		out.open(fileName,ofstream::app);
		char buffer[SIZE];
		memset(buffer, '\0', sizeof(buffer));
		strncpy(buffer,argv[2],SIZE);
		out << buffer;
		out.close();
		return 0;

	}
	else{
		cerr << "The file already exists." << endl;
		check.close();
		return 2;
	}

    }
    else{
	cerr << "Usage: >toctou filename inputstring" << endl;
	return 1;
   }

}
