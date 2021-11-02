# 编译相关
FLAGS=-tags=jsoniter
DEV_FLAGS=-gcflags="-l -N" -race
GOOS=linux
GOARCH=amd64

# 项目相关
NAME=java-web-base
#PORT=9088
COMMIT=$(shell git log -1 --pretty=format:%h)
DEV_NAME=$(NAME)-$(COMMIT)
RELEASE_VERSION=$(shell git describe --tags `git rev-list --tags --max-count=1`)
#RELEASE_NAME=$(NAME)-$(RELEASE_VERSION)
ifdef VERSION
RELEASE_VERSION=$(VERSION)
endif

# docker相关
DOCKER_REGISTRY=10.236.101.13:8443/common
DOCKER_TARGET=$(DOCKER_REGISTRY)/$(NAME):$(RELEASE_VERSION)


.PHONY: all
all: build-dev

build-dev:
	@mvn clean package -P$(ENV_SERVER_MODE)
	#@mvn clean package
	@echo "==================$(NAME) build okay=================="

build-release:
	@mvn clean package -P$(ENV_SERVER_MODE)
	#@mvn clean package
	@echo "==================$(NAME) build okay=================="

clean:
	@mvn clean
	@echo "==================clean okay=================="

docker-build: clean build-release
	@docker buildx build --platform linux/amd64 --no-cache -t $(DOCKER_TARGET) --build-arg modeenv=$(ENV_SERVER_MODE) --build-arg procname=$(NAME) .
	@echo "==================docker-build okay=================="

docker-clean:
	docker rmi $(DOCKER_TARGET)
	@echo "==================docker-clean okay=================="

docker-push:
	docker push $(DOCKER_TARGET)
	@echo "==================docker-push okay=================="

docker-all: docker-build docker-push
	@echo "==================docker-all okay=================="
