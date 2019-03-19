<?php
/**
 * Created by PhpStorm.
 * User: lishaoyao
 * Date: 2019-03-16
 * Time: 14:28
 */

class Solution
{
    /**
     * 两数之和:https://leetcode-cn.com/problems/two-sum/
     * @param $nums
     * @param $target
     * @return array
     */
    function twoSum($nums, $target)
    {
        //暴力求解
        /*for ($i = 0; $i < sizeof($nums); $i++) {
            for ($j = $i + 1; $j < sizeof($nums); $j++) {
                $tem = $nums[$i] + $nums[$j];
                if ($target == $tem){
                    return [$i,$j];
                }
            }
        }*/
        //两遍哈希求解
        /*$nums_map = [];
        for ($i = 0; $i < sizeof($nums); $i++) {
            $nums_map[$nums[$i]] = $i;
        }

        for ($i = 0; $i < sizeof($nums); $i++) {
            $tem = $target - $nums[$i];

            if (array_key_exists($tem, $nums_map) && $nums_map[$tem] != $i) {
                return [$i, $nums_map[$tem]];
            }

        }*/

        //一遍哈希
        $nums_map = [];
        for ($i = 0; $i < sizeof($nums); $i++) {
            $tem = $target - $nums[$i];
            if (array_key_exists($tem, $nums_map) && $nums_map[$tem] != $i) {
                return [$nums_map[$tem], $i];
            } else {
                $nums_map[$nums[$i]] = $i;
            }
        }

    }

    /**
     * 错误的集合:https://leetcode-cn.com/problems/set-mismatch/
     * @param $nums
     * @return array
     */
    function findErrorNums($nums)
    {
        $nums_exit = [];
        $sum_exit  = 0;//现有数组的和
        $sum_true  = 0;//实际应该拥有的和
        $num_error = 0;
        for ($i = 0; $i < sizeof($nums); $i++) {
            $sum_exit += $nums[$i];
            $sum_true += ($i + 1);
            array_key_exists($nums[$i], $nums_exit) && $num_error = $nums[$i];
            $nums_exit[$nums[$i]] = $i;
        }
        return [$num_error, $num_error + ($sum_true - $sum_exit)];
    }

    /**
     * 多米诺和托米诺平铺:https://leetcode-cn.com/problems/domino-and-tromino-tiling/
     * @param $N
     * @return int
     */
    function numTilings($N)
    {
        $M     = pow(10, 9) + 7;
        $dp    = [];
        $dp[0] = 1;
        $dp[1] = 1;
        $dp[2] = 2;
        for ($i = 3; $i <= $N; $i++) {
            $dp[$i] = ($dp[$i - 1] * 2 + $dp[$i - 3]) % $M;
        }
        return $dp[$N];
    }

    /**
     * 不同路径:https://leetcode-cn.com/problems/unique-paths/
     * @param Integer $m
     * @param Integer $n
     * @return Integer
     */
    function uniquePaths($m, $n)
    {
        $dp = [];
        for ($i = 1; $i <= $m; $i++) {
            for ($j = 1; $j <= $n; $j++) {
                if ($i == 1 || $j == 1) {
                    $dp[$i][$j] = 1;
                } else {
                    $dp[$i][$j] = $dp[$i - 1][$j] + $dp[$i][$j - 1];
                }
            }
        }
        return $dp[$m][$n];
    }

}