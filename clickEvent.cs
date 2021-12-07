using System.Collections;
using System.Collections.Generic;
using UnityEngine;
using UnityEngine.EventSystems;

public class clickEvent : MonoBehaviour
{ 
    private RaycastHit hit;
  
    private bool isPickUp = false; //열쇠 얻었는지에 대한 상태
    private bool isPressed = false; //버튼이 눌렸는지에 대한 상태 

    private TextResource textResource;
    void Start() {

        //텍스트 오브젝트 찾기.
        textResource = GameObject.Find("Text1").GetComponent<TextResource>();
    }

    // Update is called once per frame
    void Update()
    {
       

        // 기본 상호작용 용 _ 마우스를 누를 경우. _ 추가창(텍스트 오브젝트 이름) 출력 
        if (Input.GetMouseButtonDown(0))
        {
            Ray ray = Camera.main.ScreenPointToRay(Input.mousePosition);
            if (Physics.Raycast(ray, out hit))
            {
                Debug.Log("Mouse button Down");

                //텍스트 란 오브젝트 이름으로 설정, 텍스트 위치는 클릭 위치, 텍스트 활성화
                textResource.SetResource(hit.transform.gameObject.name);
                textResource.transform.position = hit.point;
                textResource.gameObject.SetActive(true);
        
            }
        }

        //물체 클릭 할 경우. (완전히) 
        if (Input.GetMouseButtonUp(0))
        {
            Debug.Log("Mouse button Up");

            //텍스트 비활성화
            textResource.gameObject.SetActive(false);
            textResource.SetResource("");

            //마우스 포지션 취득해서 대입
            Ray ray = Camera.main.ScreenPointToRay(Input.mousePosition);

            //마우스 포지션에 ray 던져서 물체 인식 시 hit에 넣음.
            if (Physics.Raycast(ray, out hit))
            {

                //클릭한 게임 오브젝트 확인용 로그 찍기
                Debug.Log(hit.transform.gameObject.name);

                //상호작용할 오브젝트_ 이름으로 인식 (열쇠는 Key라 가정.)
                if (hit.transform.gameObject.name == "Key")
                {
                    Debug.Log("click Key");

                    //먹은 상태로 변경. 
                    isPickUp = true;


                    //먹은 아이템 화면 상 삭제. 
                    Destroy(hit.transform.gameObject);

                }
                //버튼을 누를 경우 ~ 상호작용. 오브젝트 이름에 button이 있을 경우.
                else if (hit.transform.gameObject.name.Contains("button"))
                {
                    Debug.Log("click button");

                    isPressed = !isPressed; // 버튼 누르고, 해제하고.

                    //아래에 버튼을 클릭할 경우 _ 버튼이 눌리는 작용 외 추가 상호작용할 내용 추가

                }
                //기타 상호작용.
                else
                {
                    //열쇠 얻은 후, 타 오브젝트 클릭 시 열쇠 상태가 유지 되는지 확인용
                    /* if (isPickUp)
                        {
                            Debug.Log("pick up true");
                        }
                        else {
                            Debug.Log("pick up false");
                        }*/

                }

                
            }
        }
  
    }

    public bool getIsPickUp() {
        return isPickUp;
    }

    public bool getIsPressed()
    {
        return isPressed;
    }
}
