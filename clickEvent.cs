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

            if (Physics.Raycast(ray, out hit))
            {
                
                Debug.Log(hit.transform.gameObject.name);
                
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
                   case "Chair":
                        textResource.SetResource("의자이다.");
                        textResource.SetPanelActive(true);
                        Invoke("setHide", 2.75f);
                        break;
                   
                    case "tf":
                        textResource.SetResource("침대이다.");
                        textResource.SetPanelActive(true);
                        Invoke("setHide", 2.75f);
                        break;
                    case "mybutton":
                        textResource.SetResource("침대이다2.");
                        textResource.SetPanelActive(true);
                        Invoke("setHide", 2.75f);
                        break;
                    case "Key":
                        textResource.SetResource("침대이다.3");
                        textResource.SetPanelActive(true);
                        Invoke("setHide", 2.75f);
                        break;
                    case "default" : 
                         Debug.Log(hit.transform.gameObject.name);
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
