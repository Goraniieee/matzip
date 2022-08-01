#!/usr/bin/env bash

function find_idle_profile()
{
    RESPONSE_CODE=$(sudo curl -s -o /dev/null -w "%{http_code}" http://matzip-server.shop/)

    if [ "${RESPONSE_CODE}" -ge 400 ]
    then
        CURRENT_PROFILE=prod2
    else
        CURRENT_PROFILE=$(sudo curl -s http://matzip-server.shop/)
    fi

    if [ "${CURRENT_PROFILE}" == prod1 ]
    then
      IDLE_PROFILE=prod2
    else
      IDLE_PROFILE=prod1
    fi

    echo "${IDLE_PROFILE}"
}

function find_idle_port()
{
    IDLE_PROFILE=$(find_idle_profile)

    if [ "${IDLE_PROFILE}" == prod1 ]
    then
      echo "8081"
    else
      echo "8082"
    fi
}