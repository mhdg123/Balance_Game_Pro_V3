
function loadFile(input) {
                                      var file = input.files[0]; // 선택된 파일 가져오기

                                     var inputId=input.id;

                                  // 새로운 이미지 div 추가
                                     var newImage = document.createElement("img");
                                     newImage.setAttribute("class", 'img');
                                     newImage.setAttribute("id", inputId + 'Image'); // 새로운 이미지에 ID 추가

                                     // 이미지 source 가져오기
                                     newImage.src = URL.createObjectURL(file);

                                     newImage.style.width = "70%";
                                     newImage.style.height = "70%";
                                     newImage.style.objectFit = "contain";

                                     // 이미지를 image-show div에 추가
                                     var container = document.getElementById(inputId + "Input");
                                     container.innerHTML = ""; // 이미지가 추가되기 전에 이미지를 초기화하여 이전 이미지를 삭제

                                     // 이미지를 감싸는 div 추가
                                     var imageWrapper = document.createElement("div");
                                     imageWrapper.setAttribute("style", "text-align: center;"); // 가운데 정렬을 위한 스타일 적용
                                     imageWrapper.appendChild(newImage);
                                     container.appendChild(imageWrapper);

                                     // 삭제 버튼 추가
                                     var button = document.createElement("div");
                                     button.setAttribute("class", "deleteButton");
                                     button.setAttribute("id", inputId+"deleteButton");
                                     button.setAttribute("style", "color: black; text-align: center;"); // 가운데 정렬을 위한 스타일 적용
                                     button.setAttribute("onclick", "deleteImage('" + inputId + "')"); // inputId를 문자열로 전달
                                     button.textContent = "[사진등록취소]";
                                     container.appendChild(button);
                                        
                                        
                                            // 이미지를 수정했음을 표시하기 위해 hidden input의 값을 변경
                                            console.log(inputId+"Retouch");
    								var retouchInput = document.getElementById(inputId+"Retouch");
    								if (retouchInput) {
        								retouchInput.value = "T";
    								}
                                        
                                        
                                      
                                    }

                                    function deleteImage(inputId) {
                                      var image = document.getElementById(inputId+"Image"); // 추가된 이미지 가져오기
                                      var button = document.getElementById(inputId+"deleteButton"); // 삭제 버튼 가져오기
                                      if (image) {
                                        image.remove(); // 이미지 삭제
                                        document.getElementById(inputId).value = ""; // 파일 선택 input 초기화
                                      }
                                      if (button) {
                                          button.remove(); // 삭제 버튼 삭제
                                      }
                                      var retouchInput = document.getElementById(inputId+"Retouch");
    								if (retouchInput) {
        								retouchInput.value = "T";
    								}
                                    }