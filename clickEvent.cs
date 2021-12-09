using System.Collections;
using System.Collections.Generic;
using UnityEngine;

public class clickEvent : MonoBehaviour
{ 
    private RaycastHit hit;
  
    private bool isPickUp = false; //열쇠 얻었는지에 대한 상태
    TextResource textResource;

    private void Start()
    {
        textResource = GameObject.Find("Canvas").transform.Find("TalkPanel").GetComponent<TextResource>();

        if (textResource == null) {
            Debug.Log("Resource nulll");
        }

    }
    // Update is called once per frame
    void Update()
    {

        //물체 클릭 할 경우.
        if (Input.GetMouseButtonUp(0))
        {
            Debug.Log("Mouse button Up");

            //마우스 포지션 취득해서 대입
            Ray ray = Camera.main.ScreenPointToRay(Input.mousePosition);


            /*
             //실험용 대입 코드.
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

                    textResource.SetResource("열쇠를 획득하였습니다!");
                    textResource.SetPanelActive(true);

                    Invoke("setHide", 1.75f);

                    //먹은 아이템 화면 상 삭제. 
                    Destroy(hit.transform.gameObject);

                }
                //기타 상호작용.
                else {
                    textResource.SetResource(hit.transform.gameObject.name);
                    textResource.SetPanelActive(true);

                    Invoke("setHide", 1.75f);

                }
                
            }
            */
            if (Physics.Raycast(ray, out hit))
            {

                switch (hit.transform.gameObject.name) {
                    case "Locker1" :
                    case "Locker2" :
                        textResource.SetResource("공동락커이다. 쓸모있는 물건은 보이지 않는다");
                        textResource.SetPanelActive(true);
                        Invoke("setHide", 2.75f);
                        break;
                    case "Box":
                        //먹은 상태로 변경. 
                        isPickUp = true;
                        textResource.SetResource("열쇠가 들어있다. (열쇠를 획득)");
                        textResource.SetPanelActive(true);
                        Invoke("setHide", 2.75f);

                        //먹은 아이템 화면 상 삭제. 
                        Destroy(hit.transform.gameObject);
                        break;
                    case "Ladder":
                        textResource.SetResource("사다리다");
                        textResource.SetPanelActive(true);
                        Invoke("setHide", 2.75f);
                        break;

                    case "Left_ele":
                    case "Right_ele":
                        textResource.SetResource("전기조절장치이다");
                        textResource.SetPanelActive(true);
                        Invoke("setHide", 2.75f);
                        break;
                    case "Blue1":
                    case "Blue2":
                        textResource.SetResource("쓸모있어보이지 않는다");
                        textResource.SetPanelActive(true);
                        Invoke("setHide", 2.75f);
                        break;
                    case "Book":
                        textResource.SetResource("잠수함 일지이다.");
                        textResource.SetPanelActive(true);
                        Invoke("setHide", 2.75f);
                        break;
                    case "Bed1":
                    case "Bed2":
                    case "Bed3":
                    case "Bed4":
                        textResource.SetResource("침대이다.");
                        textResource.SetPanelActive(true);
                        Invoke("setHide", 2.75f);
                        break;
                    //실험용 코드2
                    case "tf":
                        textResource.SetResource("침대이다.");
                        textResource.SetPanelActive(true);
                        Invoke("setHide", 2.75f);
                        break;
                }

            }
        }
  
    }

    public bool getIsPickUp() {
        return isPickUp;
    }

    private void setHide() {
        textResource.SetPanelActive(false);
    }
}
