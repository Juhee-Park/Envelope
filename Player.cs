using System.Collections;
using System.Collections.Generic;
using UnityEngine;

public class Player : MonoBehaviour
{
    public float moveSpeed = 4; //이동속도
    public float turnSpeed = 4 * 30; // 회전 속도    

    // Start is called before the first frame update
    void Start()
    {

    }

    // Update is called once per frame
    void Update()
    {
        // 좌우 회전
        float yRotateSize = Input.GetAxis("Horizontal") * turnSpeed * Time.deltaTime;

        // 현재 y축 회전값에 더한 새로운 회전각도 계산
        float yRotate = transform.eulerAngles.y + yRotateSize;

        // 카메라 회전량을 카메라에 반영(Y축만 회전)
        transform.eulerAngles = new Vector3(0, yRotate, 0);

        // 상하 걷기
        Vector3 xMove = transform.forward * Input.GetAxis("Vertical");
        // 이동량을 좌표에 반영
        transform.position += xMove * moveSpeed * Time.deltaTime;


    }
}
