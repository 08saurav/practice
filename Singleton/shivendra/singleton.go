package main

import (
	"fmt"
	"strconv"
	"sync"
)

type Singleton struct {
	val string
}

var singleton *Singleton;


func getInstance(val string) Singleton{
	var mut sync.Mutex;
	if singleton == nil {
		mut.Lock();
		defer mut.Unlock();
		if singleton == nil {
			singleton = &Singleton {
				val : val,
			}
		}
	}

	return *singleton;
}

func main() {
	var wg sync.WaitGroup;
	wg.Add(30)
	for i := 0; i < 30; i++ {
		go func(idx int) {
			defer wg.Done();
			fmt.Println(getInstance(strconv.Itoa(idx)).val);
		} (i);
	}
	wg.Wait();
}