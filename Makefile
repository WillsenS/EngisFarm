CXX := g++

# The -pedantic-error flag will fail compilation if there is any code that violate the C and C++ standard
# The -Wall flag will turn on most of g++ warning
# The -Wextra and -Werror flag will turn on more warning
CXXFLAGS := -pedantic-errors -Wall -Wextra -Werror

# Directory for all the generated files contents
BUILD    := ./build

# Directory for all the generated object files
CPP_OBJ_DIR  := $(BUILD)/objects

# Directory for all the generated application
CPP_APP_DIR  := $(BUILD)/apps/cpp

# Our application
TARGET   := engisfarm

# Add the `include` pathname to the include file search path
INCLUDE  := -I cpp/include/

# Wildcard to all the source file
# Module folder can be changed to our EngisFarm module
CPP_SRC      :=                      \
	$(wildcard cpp/src/module1/*.cpp) \
	$(wildcard cpp/src/module2/*.cpp) \
	$(wildcard cpp/src/module3/*.cpp) \
	$(wildcard cpp/src/*.cpp)         \

# Target dependency on objects files
CPP_OBJECTS := $(CPP_SRC:%.cpp=$(CPP_OBJ_DIR)/%.o)

# The `all` command
all: build $(CPP_APP_DIR)/$(TARGET)

# Generating .o files
# Compile the .c files before generating
# -p create all the directory, parent included
# -c compile only, will not do any linking
# $@ automatic variable for the target name, the one before `:`
# $< automatic variable for the first item in dependecy list, the one after `:`
$(CPP_OBJ_DIR)/%.o: %.cpp
	@mkdir -p $(@D)
	$(CXX) $(CXXFLAGS) $(INCLUDE) -o $@ -c $<

# Generating the application
# @^ automatic variable for all the items in dependecy list
$(CPP_APP_DIR)/$(TARGET): $(CPP_OBJECTS)
	@mkdir -p $(@D)
	$(CXX) $(CXXFLAGS) $(INCLUDE) -o $(CPP_APP_DIR)/$(TARGET) $^

# Denote make task
.PHONY: all build clean debug release

# Default task to run when make is invoked without target
.DEFAULT_GOAL := all

# making the directory for generating files
build:
	@mkdir -p $(CPP_APP_DIR)
	@mkdir -p $(CPP_OBJ_DIR)

# Add the -O2 flag for performance optimization
# May take longer to compile but reduces size of generated code
release: CXXFLAGS += -O2
release: all

# Remove all generated files
# -r remove directories and their contents recursively
# -v show what is happening and what is being done
# -f force remove, will not be prompted with "Do you want to remove the files? Yes or No"
clean:
	-@rm -rvf $(CPP_OBJ_DIR)/*
	-@rm -rvf $(CPP_APP_DIR)/*