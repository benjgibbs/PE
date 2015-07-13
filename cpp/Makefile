
CC := c++

LDFLAGS := -L /usr/local/lib 
CPP_FILES := $(wildcard *.cpp)

CPP_FLAGS := -Wall 
CPP_FLAGS += -std=c++11 
#CPP_FLAGS += -stdlib=libstdc++ 
CPP_FLAGS += -I /usr/local/include 
CPP_FLAGS += -g 
CPP_FLAGS += -O2

LIBS := sieve.cpp 
LIBS += -l boost_unit_test_framework-mt

FLAGS := $(LDFLAGS) $(CPP_FLAGS)

% : %.cpp
	$(CC) $(FLAGS) $(LIBS) $< -o $@
clean :
	rm -rf $(patsubst %.cpp,%,$(CPP_FILES))
