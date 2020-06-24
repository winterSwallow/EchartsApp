          let data = [
              ['114.309062','30.548891', 41334],
          ];
          let areaData = [];
          data.map(item => { // 扩大热力图效果
              areaData.push(...new Array(3).fill(item));
          });
          var option = {
          backgroundColor: '#ccc',
          tooltip: {
              show: false,
              trigger: 'item',
              axisPointer: {
                  type: 'shadow'
              }
          },
          visualMap: {
              bottom: 20,
              left: 200,
              show: false,
              color: ['#ff4601', '#fffc00', '#87cffa'],
              calculable: true,
              textStyle: {
                  color: '#fff',
                  fontSize: 12
              }
          },
          grid: {
              height: '100%',
              width: '100%'
          },

          geo: {
              map: 'wuhan',
              label: {
                  show: true
              },
              top: 'center',
              left: '5%',
              roam: false,
              width: '90%',
              height: '95%',
              zoom: 1.01,
              label: {
                  normal: {
                      show: true,
                      color: '#fff'
                  },
                  emphasis: {
                      color: '#fff'
                  }
              },
              itemStyle: {
                  normal: {
                      areaColor: '#76b1ff',
                      borderColor: '#eee',
                      shadowColor: '#76b1ff',
                      shadowBlur: 10,
                      borderWidth: 1
                  },
                  emphasis: {
                      // 鼠标移入颜色
                      areaColor: '#409EFF',
                      borderWidth: 0
                  }
              }
          },

          series: [{
              mapType: 'wuhan',
              top: 'center',
              left: 'center',
              width: '100%',
              height: '100%',

              name: 'AQI',
              type: 'heatmap',
              coordinateSystem: 'geo',
              blurSize: 40,
              data: areaData,
              // 鼠标移入
              emphasis: {
                  show: false,
                  itemStyle: {
                      areaColor: 'rgb(255,255,0,1)'
                  }
              }
          }]
      }