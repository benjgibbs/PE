
CC := c++

LDFLAGS := -L /usr/local/lib 
CPP_FILES := $(wildcard *.cpp)
BINS := $(patsubst %.cpp, ./bin/%, $(CPP_FILES))

CPP_FLAGS := -Wall 
CPP_FLAGS += -std=c++14 
#CPP_FLAGS += -stdlib=libstdc++ 
CPP_FLAGS += -I /usr/local/include 
CPP_FLAGS += -g 
CPP_FLAGS += -O3

LIBS := sieve.cpp 
LIBS += -l boost_unit_test_framework-mt

FLAGS := $(LDFLAGS) $(CPP_FLAGS)

./bin :
	mkdir -p ./bin

$(BINS) : ./bin/% : %.cpp ./bin
	$(CC) $(FLAGS) $(LIBS) $< -o $@

clean :
	rm -rf $(BINS)
